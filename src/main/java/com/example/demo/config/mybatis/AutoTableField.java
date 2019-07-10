package com.example.demo.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.demo.entity.User;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: ChangYu
 * @Date: 3/28/2019 2:22 PM
 * @Version 1.0
 */
@Component
public class AutoTableField implements MetaObjectHandler {
    /**
     * 自定义sql时，必须预留该字段
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createDate = this.getFieldValByName("createDate",metaObject);
        Object createBy = this.getFieldValByName("createBy",metaObject);
        if(null == createDate){
            this.setInsertFieldValByName("createDate", new Date(),metaObject);
        }
        User user =(User)SecurityUtils.getSubject().getPrincipal();
        if(null==createBy){
            this.setInsertFieldValByName("createBy",user.getUsername(),metaObject);
        }
    }
    /**
     * 自定义sql时，必须预留该字段
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        User user =(User)SecurityUtils.getSubject().getPrincipal();
        this.setUpdateFieldValByName("updateDate", new Date(), metaObject);
        this.setUpdateFieldValByName("updateBy", user.getUsername(), metaObject);
    }
}
