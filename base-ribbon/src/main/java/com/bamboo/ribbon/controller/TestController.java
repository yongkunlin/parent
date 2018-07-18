package com.bamboo.ribbon.controller;

import com.bamboo.ribbon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于测试
 * Created by yklin on 2018/4/18.
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("ribbon")
    public String testRibbon(@RequestParam String name) {
        return testService.testRibbon(name);
    }
}
