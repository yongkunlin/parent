package com.bamboo.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 远程调用
 * Created by yklin on 2018/4/18.
 */
@Service
public class TestService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 调用 system-service 的 helloWorld 接口
     * HystrixCommand 断路时执行的方法
     *
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "testRibbonError")
    public String testRibbon(String name) {
        return restTemplate.getForObject("http://system-service/helloWorld?name=" + name, String.class);
    }

    //system-service只关掉其中一个也会进入此方法 ???
    private String testRibbonError(String name) {
        System.out.println("error!");
        return "error";
    }
}
