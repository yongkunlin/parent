package com.bamboo.entity;

import com.bamboo.core.base.entity.BaseEntity;

/**
 * job任务
 * Created by yklin on 2018/7/18.
 */
public class JobTask extends BaseEntity {
    //job名称
    private String jobName;
    //分组
    private String groupName;
    //策略
    private Ploy ploy;
    //所属数据库
    private String dataBase;
    //是否启用
    private Integer izUse;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Ploy getPloy() {
        return ploy;
    }

    public void setPloy(Ploy ploy) {
        this.ploy = ploy;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public Integer getIzUse() {
        return izUse;
    }

    public void setIzUse(Integer izUse) {
        this.izUse = izUse;
    }
}
