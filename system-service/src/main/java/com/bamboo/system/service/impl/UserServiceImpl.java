package com.bamboo.system.service.impl;

import com.bamboo.core.util.UUIDUtil;
import com.bamboo.entity.system.User;
import com.bamboo.entity.validata.UserValidata;
import com.bamboo.core.base.exception.ServiceException;
import com.bamboo.system.mapper.UserMapper;
import com.bamboo.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @SuppressWarnings("all")
    private UserMapper userMapper;

    @Override
    public User expand(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new ServiceException("参数错误", this.getClass().getName());
        }
        return userMapper.getEnitty(id);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public User findUserByUserCodeAndPassword(String userCode, String password) {
        if (!UserValidata.validataUserCodeAndPassword(userCode, password)) {
            throw new ServiceException("参数错误", this.getClass().getName());
        }
        return userMapper.findUserByUserCodeAndPassword(userCode, password);
    }

    @Override
    public User findUserByUserCode(String userCode) {
        if (StringUtils.isEmpty(userCode)) {
            throw new ServiceException("参数错误", this.getClass().getName());
        }
        return userMapper.findUserByUserCode(userCode);
    }

    @Override
    @Transactional
    public void register(User user) {
        if (!UserValidata.validata(user)) {
            throw new ServiceException("参数错误", this.getClass().getName());
        }
        User findUser = findUserByUserCode(user.getUserCode());
        if (null != findUser) {
            throw new ServiceException("账号已存在", this.getClass().getName());
        }
        user.setId(UUIDUtil.get32UpperCase());
        saveUser(user);
    }

    /**
     * 新增用户
     *
     * @param user
     */
    private void saveUser(User user) {
        if (!UserValidata.validata(user)) {
            throw new ServiceException("参数错误", this.getClass().getName());
        }
        try {
            userMapper.saveEntity(user);
        } catch (Exception e) {
            throw new ServiceException("新增失败", this.getClass().getName(), e);
        }
    }
}
