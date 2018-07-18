package com.bamboo.simulate;


import com.bamboo.entity.system.Org;

/**
 * 模拟admin账号
 * Created by yklin on 2018/5/28.
 */
public class UserAdmin {
    private String userName = "admin";
    private String userCode = "admin";
    private String password = "admin";
    private Org org = new Org();
    private String simulateIp = "127.0.0.1";

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

    public String getSimulateIp() {
        return simulateIp;
    }

    public void setSimulateIp(String simulateIp) {
        this.simulateIp = simulateIp;
    }
}
