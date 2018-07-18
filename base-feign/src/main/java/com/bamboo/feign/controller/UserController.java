package com.bamboo.feign.controller;

import com.bamboo.entity.system.User;
import com.bamboo.feign.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户控制中心
 * Created by yklin on 2018/5/10.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/queryUser", method = RequestMethod.GET)
    @ResponseBody
    public String queryUser(@RequestParam String name) {
        List<User> users = userClient.queryUser(name);
        return null;
    }
}
