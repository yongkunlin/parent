package com.bamboo.system.service.impl;

import com.bamboo.core.util.IpAddressUtil;
import com.bamboo.core.util.UUIDUtil;
import com.bamboo.entity.system.Org;
import com.bamboo.entity.system.Session;
import com.bamboo.entity.system.User;
import com.bamboo.entity.validator.SessionValidator;
import com.bamboo.core.base.exception.ServiceException;
import com.bamboo.system.mapper.SessionMapper;
import com.bamboo.system.service.OrgService;
import com.bamboo.system.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 逻辑实现
 * Created by yklin on 2018/5/15.
 */
@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    @SuppressWarnings("all")
    private SessionMapper sessionMapper;
    @Autowired
    private OrgService orgService;

    @Override
    public Session addSession(HttpServletRequest request, User user) {
        if (null == user || null == request) {
            throw new ServiceException("参数错误", this.getClass().getName());
        }
        String accessIp = IpAddressUtil.getIpAddr(request);
        StringBuffer requestURL = request.getRequestURL();
        Org org = orgService.expand(user.getOrg().getId());
        Session session = new Session(UUIDUtil.get32UpperCase(), user, org, accessIp, new Date(), requestURL.toString(), SessionValidator.LOGIN_IN);
        saveSession(session);
        return session;
    }

    /**
     * 新增会话记录
     *
     * @param session
     */
    @Transactional
    private void saveSession(Session session) {
        if (null == session) {
            throw new ServiceException("参数错误", this.getClass().getName());
        }
        try {
            int num = sessionMapper.saveEntity(session);
            if (1 != num) {
                throw new ServiceException("新增失败", this.getClass().getName());
            }
        } catch (Exception e) {
            throw new ServiceException("新增失败", this.getClass().getName());
        }
    }
}
