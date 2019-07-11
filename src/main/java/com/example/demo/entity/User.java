package com.example.demo.entity;

import com.example.demo.base.AttributeEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: ChangYu
 * @Version 1.0
 * 用户表
 */
@Entity
@Table(name = "t_user")
public class User extends AttributeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "role_id")
    @OneToOne
    private Role role;
    @Column(length = 50)
    private String realname;
    @Column(length = 50)
    private String username;
    @Column(length = 100)
    private String password;
    @Column(length = 100)
    private String phone;
    @Column(length = 100)
    private String email;
    @Column(length = 5)
    private int status=1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
