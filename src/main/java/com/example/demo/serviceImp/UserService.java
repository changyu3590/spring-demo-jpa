package com.example.demo.serviceImp;

import com.example.demo.base.BaseService;
import com.example.demo.base.ServiceException;
import com.example.demo.config.redis.RedisUtil;
import com.example.demo.dto.GeneralResponseDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleDao;
import com.example.demo.repository.UserDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static cn.hutool.crypto.digest.DigestUtil.md5Hex;

/**
 * @Author: ChangYu
 * @Version 1.0
 */
@Service
public class UserService extends BaseService<UserDao> {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RoleDao roleDao;
    @Value("${spring.session.timeout}")
    private long timeout;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public GeneralResponseDto login(HttpServletRequest request, String username, String password) {
        // 从SecurityUtils里边创建一个 subject
         Subject subject = SecurityUtils.getSubject();
         // 在认证提交前准备 token（令牌）
         UsernamePasswordToken token = new UsernamePasswordToken(username, md5Hex(password));
        // 执行认证登陆
         subject.login(token);
        // 根据权限，指定返回数据
        User user = (User) subject.getPrincipal();
        redisUtil.expireKey(user.getId().toString(), request.getSession().getId(), timeout, TimeUnit.SECONDS);
        return GeneralResponseDto.addSuccess(user);
    }


    /**
     * 保存用户
     * @return
     */
    public void doSaveUser(User user) {
        //修改
        if(user.getId()!=null){
            if(!StringUtils.isEmpty(user.getPassword())){
                user.setPassword(md5Hex(user.getPassword()));
            }
            this.dao.save(user);
        //新增
        }else{
            if (this.dao.findByUsername(user.getUsername()) != null) {
                throw new ServiceException("用户名已存在");
            }
            if (user.getRole() == null) {
                Role role = roleDao.findAll(new Sort(Sort.Direction.ASC, "id")).get(1);
                user.setRole(role);
            }
            user.setPassword(md5Hex(user.getPassword()));
            this.dao.save(user);
        }
    }


    /**
     * 分页查询
     *
     * @return
     */
    public Page<User> findAllUser(String username, String phone, String realname, String status, String email, int pageNo, int pageSize) {
        Pageable page = new PageRequest(pageNo, pageSize);
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (!StringUtils.isEmpty(username)) {
                    predicates.add(criteriaBuilder.like(root.get("username"), "%" + username + "%"));
                }
                if (!StringUtils.isEmpty(phone)) {
                    predicates.add(criteriaBuilder.like(root.get("phone"), "%" + phone + "%"));
                }
                if (!StringUtils.isEmpty(realname)) {
                    predicates.add(criteriaBuilder.like(root.get("realname"), "%" + realname + "%"));
                }
                if (!StringUtils.isEmpty(status)) {
                    predicates.add(criteriaBuilder.equal(root.get("status"), status));
                }
                if (!StringUtils.isEmpty(email)) {
                    predicates.add(criteriaBuilder.like(root.get("email"), "%" + email + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

            }
        };
        Page<User> pages = this.dao.findAll(specification, page);
        return pages;
    }

    /**
     * 删除
     *
     * @return
     */
    public void doDelete(long id) {
        this.dao.deleteById(id);
    }


    public void logout(Subject subject) {
        redisUtil.deleteKey(((User) subject.getPrincipal()).getId().toString());
    }

}
