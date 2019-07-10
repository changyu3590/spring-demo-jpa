package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

/**
 * @Author: ChangYu
 * @Version 1.0
 */
@Mapper
public interface RoleDao extends BaseMapper<Role> {

}