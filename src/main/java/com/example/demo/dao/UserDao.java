package com.example.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

/**
 * @Author: ChangYu
 * @Version 1.0
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select("SELECT * FROM t_user where username=#{username}")
    User findByUsername(String username);

    IPage<User> findUsersByPage(Page page,@Param("username")String username,
                                @Param("phone")String phone,
                                @Param("realname")String realname,
                                @Param("status")String status,
                                @Param("email")String email
                                );
    void update(User user);
}
