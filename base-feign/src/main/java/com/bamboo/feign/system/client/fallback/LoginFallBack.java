package com.bamboo.feign.system.client.fallback;

import com.bamboo.feign.system.client.LoginClient;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录断熔实现
 * Created by yklin on 2018/7/25.
 */
@Component
public class LoginFallBack implements LoginClient {
    @Override
    public Map<String, Object> login(HttpServletRequest request, String userCode, String password, String validataCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("state", "服务器崩溃了");
        return map;
    }
}
