package com.bamboo.service;

import com.bamboo.entity.JobTask;

/**
 * job任务
 * Created by yklin on 2018/7/10.
 */
public interface JobTaskService {

    /**
     * 刷新重启
     */
    void refreshTrigger();

    /**
     * 指定启动
     */
    void refreshTrigger(JobTask jobTask);

}
