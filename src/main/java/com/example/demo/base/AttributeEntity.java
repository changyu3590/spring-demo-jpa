package com.example.demo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: ChangYu
 * @Version 1.0
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AttributeEntity   implements Serializable {
    @Column(name = "created_by", length = 50, updatable = false)
    @CreatedBy
    private String createBy; // 创建者

    @Column(name = "created_date", length = 50, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @CreatedDate
    private Date createDate; // 创建日期

    @Column(name = "update_by", length = 50, updatable = false)
    @LastModifiedBy
    private String updateBy; // 更新者

    @Column(name = "update_date", length = 50, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @LastModifiedDate
    private Date updateDate; // 更新日期

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }





}
