package com.bamboo.feign.system.controller;

import com.bamboo.feign.system.client.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录
 * Created by yklin on 2018/7/25.
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    @SuppressWarnings("all")
    private LoginClient loginClient;

    /**
     * 跳转
     *
     * @param page
     * @return
     */
    @RequestMapping("dispatch/{page}")
    public String dispatch(@PathVariable String page) {
        return "index";
    }

    /**
     * 登录
     *
     * @param request
     * @param userCode
     * @param password
     * @param validataCode
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, String userCode, String password, String validataCode) {
        Map<String, Object> map = loginClient.login(request, userCode, password, validataCode);
        return map;
    }

    /**
     * 验证码
     *
     * @param request
     * @return
     */
    @RequestMapping("validataCode")
    @ResponseBody
    public String validataCode(HttpServletRequest request) {
        return loginClient.validataCode(request);
    }
}
