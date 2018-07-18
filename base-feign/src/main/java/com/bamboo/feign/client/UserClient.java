package com.bamboo.feign.client;

import com.bamboo.entity.system.User;
import com.bamboo.feign.client.fallback.UserClientFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户远程调度接口
 * Created by yklin on 2018/5/10.
 */
@FeignClient(value = "system-web", fallback = UserClientFallBack.class)
public interface UserClient {

    @RequestMapping(value = "api/user/queryUser", method = RequestMethod.GET)
    List<User> queryUser(@RequestParam(value = "name") String name);
}
