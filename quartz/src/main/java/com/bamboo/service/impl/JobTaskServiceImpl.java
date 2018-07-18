package com.bamboo.service.impl;

import com.bamboo.core.base.exception.ServiceException;
import com.bamboo.entity.JobTask;
import com.bamboo.mapper.JobTaskMapper;
import com.bamboo.service.JobTaskService;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * job任务
 * Created by yklin on 2018/7/10.
 */
@Service
public class JobTaskServiceImpl implements JobTaskService {

    @Autowired
    @SuppressWarnings("all")
    private JobTaskMapper jobTaskMapper;
    @Autowired
    private Scheduler scheduler;

    @Override
    public void refreshTrigger() {
        try {
            List<JobTask> list = jobTaskMapper.queryAll();
            for (JobTask jobTask : list) {
                refreshTrigger(jobTask);
            }
        } catch (Exception e) {
            throw new ServiceException("刷新任务失败", this.getClass().getName(), e);
        }
    }

    @Override
    public void refreshTrigger(JobTask jobTask) {
        if (null == jobTask) {
            return;
        }
        Integer izUse = jobTask.getIzUse();
        String name = jobTask.getJobName();
        String group = jobTask.getGroupName();
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(name, group);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger != null) {//任务已存在
                if (izUse == 1) {
                    return;
                }
                JobKey jobKey = JobKey.jobKey(name, group);
                scheduler.deleteJob(jobKey);

            } else {//任务不存在
                if (izUse != 1) {
                    return;
                }
                JobDetail jobDetail = null;
                // 创建JobDetail（数据库中job_name存的任务全路径，这里就可以动态的把任务注入到JobDetail中）
                jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName(group)).withIdentity(name, group).build();
                // 表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobTask.getPloy().getCron());
                // 按新的cronExpression表达式构建一个新的trigger
                trigger = TriggerBuilder.newTrigger().withIdentity(name, group).withSchedule(scheduleBuilder).build();
                // 把trigger和jobDetail注入到调度器
                scheduler.scheduleJob(jobDetail, trigger);
            }
        } catch (Exception e) {
            throw new ServiceException("启动任务失败", this.getClass().getName(), e);
        }

    }
}
