package com.bamboo.entity.system;

import java.util.Date;

/**
 * 日志
 * Created by yklin on 2018/4/28.
 */
public class Log {

    //主键
    private String id;

    //等级
    private Integer level;

    //类型
    private Integer type;

    //操作对象
    private String operatorObj;

    //操作描述
    private String operatorDescribe;

    //模块
    private String modle;

    //操作人
    private String operatorUser;

    //操作时间
    private Date operatorTime;

    //操作ip
    private String operatorIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOperatorObj() {
        return operatorObj;
    }

    public void setOperatorObj(String operatorObj) {
        this.operatorObj = operatorObj;
    }

    public String getOperatorDescribe() {
        return operatorDescribe;
    }

    public void setOperatorDescribe(String operatorDescribe) {
        this.operatorDescribe = operatorDescribe;
    }

    public String getModle() {
        return modle;
    }

    public void setModle(String modle) {
        this.modle = modle;
    }

    public String getOperatorUser() {
        return operatorUser;
    }

    public void setOperatorUser(String operatorUser) {
        this.operatorUser = operatorUser;
    }

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    public String getOperatorIp() {
        return operatorIp;
    }

    public void setOperatorIp(String operatorIp) {
        this.operatorIp = operatorIp;
    }
}
