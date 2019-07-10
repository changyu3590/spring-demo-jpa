package com.example.demo.dao;


import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: ChangYu
 * @Version 1.0
 */
@Mapper
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    @Query(value = "SELECT * FROM t_user where username=#{username}", nativeQuery = true)
    User findByUsername(String username);

}