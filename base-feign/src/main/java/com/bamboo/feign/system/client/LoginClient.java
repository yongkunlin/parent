package com.bamboo.feign.system.client;

import com.bamboo.feign.system.client.fallback.LoginFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录
 * Created by yklin on 2018/7/25.
 */
@FeignClient(value = "system-web", fallback = LoginFallBack.class)
public interface LoginClient {

    @RequestMapping("api/session/login")
    Map<String, Object> login(@RequestParam("request") HttpServletRequest request, @RequestParam("userCode") String userCode, @RequestParam("password") String password, @RequestParam("validataCode") String validataCode);

    @RequestMapping("api/session/validataCode")
    String validataCode(@RequestParam("request")HttpServletRequest request);
}
