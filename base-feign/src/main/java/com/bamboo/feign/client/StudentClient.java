package com.bamboo.feign.client;

import com.bamboo.entity.school.SchoolStudent;
import com.bamboo.feign.client.fallback.SchoolClientFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 学生远程调度接口
 * Created by yklin on 2018/5/10.
 */
@FeignClient(value = "school-web", fallback = SchoolClientFallBack.class)
public interface StudentClient {

    @RequestMapping(value = "api/stu/queryStudent", method = RequestMethod.GET)
    List<SchoolStudent> queryStudent();
}
