package com.bamboo.api;

import com.bamboo.service.JobTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * job控制器
 * Created by yklin on 2018/7/10.
 */
@RestController
public class JobApi {

    @Autowired
    @SuppressWarnings("all")
    private JobTaskService jobTaskService;


}
