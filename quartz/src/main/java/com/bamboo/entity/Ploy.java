package com.bamboo.entity;

import com.bamboo.core.base.entity.BaseEntity;

/**
 * 策略
 * Created by yklin on 2018/7/18.
 */
public class Ploy extends BaseEntity {

    //策略名称
    private String name;

    //策略表达式
    private String cron;

    //策略类型
    private Integer type;

    //备注
    private String remark;

    //排序
    private Integer seq;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
