package com.example.demo.entity;

import com.example.demo.base.AttributeEntity;

import javax.persistence.*;
import java.io.Serializable;
/**
 * 角色权限表
 */
@Entity
@Table(name = "t_role")
public class Role extends AttributeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;
    @Column(length = 100)
    private String permissionName;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
    