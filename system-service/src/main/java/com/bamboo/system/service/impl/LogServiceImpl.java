package com.bamboo.system.service.impl;

import com.bamboo.core.util.UUIDUtil;
import com.bamboo.entity.system.Log;
import com.bamboo.entity.system.Session;
import com.bamboo.entity.validata.LogValidata;
import com.bamboo.simulate.UserAdmin;
import com.bamboo.core.base.exception.ServiceException;
import com.bamboo.system.mapper.LogMapper;
import com.bamboo.system.service.LogService;
import com.bamboo.system.util.ThreadVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 日志逻辑实现
 * Created by yklin on 2018/5/28.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    @SuppressWarnings("all")
    private LogMapper logMapper;

    @Override
    @Transactional
    public void log(Integer level, Integer type, String strObj, String describe, String model) {
        Log log = new Log();
        log.setId(UUIDUtil.get32UpperCase());
        log.setLevel(level);
        log.setType(type);
        log.setOperatorObj(strObj);
        log.setOperatorDescribe(describe);
        log.setModle(model);
        if (null == ThreadVariable.getSession()) {
            logByNoSession(log);
        } else {
            logBySession(log);
        }
        saveLog(log);
    }

    @Override
    public void logBySession(Log log) {
        Session session = ThreadVariable.getSession();
        log.setOperatorUser(session.getUser().getUserName());
        log.setOperatorTime(new Date());
        log.setOperatorIp(session.getAccessIp());
    }

    @Override
    public void logByNoSession(Log log) {
        UserAdmin userAdmin = new UserAdmin();
        log.setOperatorUser(userAdmin.getUserName());
        log.setOperatorTime(new Date());
        log.setOperatorIp(userAdmin.getSimulateIp());
    }

    private void saveLog(Log log) {
        if (!LogValidata.validata(log)) {
            throw new ServiceException("参数错误", this.getClass().getName());
        }
        try {
            int num = logMapper.saveEntity(log);
            if (1 != num) {
                throw new ServiceException("新增失败", this.getClass().getName());
            }
        } catch (Exception e) {
            throw new ServiceException("新增失败", this.getClass().getName(), e);
        }
    }
}
