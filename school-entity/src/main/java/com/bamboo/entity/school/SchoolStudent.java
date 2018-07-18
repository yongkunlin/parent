package com.bamboo.entity.school;

import com.bamboo.core.base.entity.BaseEntity;

/**
 * 学生
 * Created by yklin on 2018/5/10.
 */
public class SchoolStudent extends BaseEntity {
    private static final long serialVersionUID = -7096523356546403695L;
    //    姓名
    private String stuName;

    //    编码
    private String stuCode;

    private String userId;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuCode() {
        return stuCode;
    }

    public void setStuCode(String stuCode) {
        this.stuCode = stuCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
