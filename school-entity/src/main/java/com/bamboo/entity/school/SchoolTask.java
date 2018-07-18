package com.bamboo.entity.school;

import com.bamboo.core.base.entity.BaseEntity;

/**
 * 任务
 * Created by yklin on 2018/5/15.
 */
public class SchoolTask extends BaseEntity {
    private String taskName;

    private String taskGroup;

    private Integer izClose;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup;
    }

    public Integer getIzClose() {
        return izClose;
    }

    public void setIzClose(Integer izClose) {
        this.izClose = izClose;
    }
}
