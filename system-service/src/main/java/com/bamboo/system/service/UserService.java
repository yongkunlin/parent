package com.bamboo.system.service;

import com.bamboo.entity.system.User;

import java.util.List;

/**
 * 用户逻辑接口
 * Created by yklin on 2018/4/28.
 */
public interface UserService {

    /**
     * 扩展
     *
     * @param id
     * @return
     */
    User expand(String id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> queryAll();

    /**
     * 根据账号密码查询用户
     *
     * @param userCode
     * @param password
     * @return
     */
    User findUserByUserCodeAndPassword(String userCode, String password);

    /**
     * 根据账号名查询用户
     *
     * @param userCode
     * @return
     */
    User findUserByUserCode(String userCode);

    /**
     * 用户注册
     *
     * @param user
     */
    void register(User user);
}
