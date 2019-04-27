package com.bootdo.common.config;

import com.bootdo.common.service.impl.*;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @program: lottery
 * @description: ${description}
 * @author: tzy
 * @create: 2019-03-26 17:01
 **/
@Component
public class MyScheduler {


    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
//        startJob1(scheduler);
//        startModel(scheduler);
//        startJobPaiLiang(scheduler);
//        startJobYear(scheduler);
//        startJobProd(scheduler);

    }

    private void startJob1(Scheduler scheduler) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(BrandJobServiceImpl.class)
                .withIdentity("job1", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/3 * * * ? ");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    private void startModel(Scheduler scheduler) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(ModelJobServiceImpl.class)
                .withIdentity("job2", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/3 * * * ? ");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("startModel", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }


    private void startJobPaiLiang(Scheduler scheduler) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(PailiangJobServiceImpl.class)
                .withIdentity("job3", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/3 * * * ? ");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("startJobPaiLiang", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    private void startJobYear(Scheduler scheduler) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(YearJobServiceImpl.class)
                .withIdentity("job4", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/3 * * * ? ");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("startJobYear", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }


    private void startJobProd(Scheduler scheduler) throws SchedulerException{
        JobDetail jobDetail = JobBuilder.newJob(ProdJobServiceImpl.class)
                .withIdentity("job4", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/3 * * * ? ");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("startJobProd", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

}
