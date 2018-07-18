package com.bamboo.system.service;

import com.bamboo.entity.system.Session;
import com.bamboo.entity.system.User;

import javax.servlet.http.HttpServletRequest;

/**
 * session逻辑接口
 * Created by yklin on 2018/5/15.
 */
public interface SessionService {

    /**
     * 添加会话
     * @param request
     * @param user
     * @return
     */
    Session addSession(HttpServletRequest request, User user);

}
