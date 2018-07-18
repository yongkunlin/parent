package com.bamboo.system.service;

import com.bamboo.entity.system.Log;

/**
 * 日志逻辑接口
 * Created by yklin on 2018/5/28.
 */
public interface LogService {

    void log(Integer level, Integer type, String strObj, String describe, String model);

    void logBySession(Log log);

    void logByNoSession(Log log);
}
