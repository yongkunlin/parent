package com.bamboo.feign.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * Created by yklin on 2018/7/26.
 */
@Controller
@RequestMapping("index")
public class IndexController {

    /**
     * 跳转指定界面
     *
     * @param page
     * @return
     */
    @RequestMapping("toPage/{page}")
    public String toPage(@PathVariable String page) {
        return page;
    }

    /**
     * 查询资源路径并返回
     *
     * @param key
     * @return
     */
    @RequestMapping("toResource/{key}")
    public String toResource(@PathVariable String key) {
        return key;
    }
}
