package com.example.demo.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: ChangYu
 * @Version 1.0
 */
public class AttributeEntity   implements Serializable {
    private String attr1;
    private String attr2;
    private String attr3;
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy; // 创建者
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate; // 创建日期
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy; // 更新者
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
    private Date updateDate; // 更新日期
    public String getAttr1() {
        return attr1;
    }

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

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }



}
