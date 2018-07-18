package com.bamboo.test;


import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by yklin on 2018/7/9.
 */
public class TestJobScheduler {

    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder
                .newJob(TestJob.class)
                .withIdentity("testJob", "group")
                .build();
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("testJob", "group")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(2)
                                .repeatForever()
                )
                .build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
