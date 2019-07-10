package com.example.demo.dao;

import com.example.demo.entity.Role;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: ChangYu
 * @Version 1.0
 */
@Mapper
public interface RoleDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

}