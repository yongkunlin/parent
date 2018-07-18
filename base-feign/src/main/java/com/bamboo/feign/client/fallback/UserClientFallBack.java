package com.bamboo.feign.client.fallback;

import com.bamboo.entity.system.User;
import com.bamboo.feign.client.UserClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 断熔实现
 * Created by yklin on 2018/5/10.
 */
@Component
public class UserClientFallBack implements UserClient {
    @Override
    public List<User> queryUser(String name) {
        System.out.println("err: " + name);
        return null;
    }
}
