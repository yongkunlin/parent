package com.bamboo.entity.system;

import com.bamboo.core.base.BaseEntity;

/**
 * 用户
 * Created by yklin on 2018/4/28.
 */
public class User extends BaseEntity {
    //    姓名
    private String userName;
    //    编码
    private String userCode;
    //    密码
    private String password;
    //    部门
    private Org org;

    public User() {
    }

    public User(String userCode, String password) {
        this.userCode = userCode;
        this.password = password;
    }

    public User(String userName, String userCode, String password, Org org) {
        this.userName = userName;
        this.userCode = userCode;
        this.password = password;
        this.org = org;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userCode='" + userCode + '\'' +
                ", password='" + password + '\'' +
                ", org=" + org +
                '}';
    }
}
