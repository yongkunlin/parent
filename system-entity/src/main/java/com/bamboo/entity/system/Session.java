package com.bamboo.entity.system;

import java.util.Date;

/**
 * session
 * Created by yklin on 2018/5/21.
 */
public class Session {
    //    主键
    private String id;
    //    用户
    private User user;
    //    部门
    private Org org;
    //    访问ip
    private String accessIp;
    //    访问时间
    private Date accessTime;
    //    访问地址
    private String accessUrl;
    //    状态
    private Integer state;

    public Session() {
    }

    public Session(String id, User user, Org org, String accessIp, Date accessTime, String accessUrl, Integer state) {
        this.id = id;
        this.user = user;
        this.org = org;
        this.accessIp = accessIp;
        this.accessTime = accessTime;
        this.accessUrl = accessUrl;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public String getAccessIp() {
        return accessIp;
    }

    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
