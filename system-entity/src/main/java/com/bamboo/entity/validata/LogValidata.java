package com.bamboo.entity.validata;

import com.bamboo.entity.system.Log;
import org.springframework.util.StringUtils;

/**
 * 日志常量以及校验
 * Created by yklin on 2018/5/28.
 */
public class LogValidata {

    public static final String ENTITY_NAME = "log";
    /**
     * 日志级别
     */
    //正常
    public static final Integer LEVEL_NORMAL = 1;
    //警告
    public static final Integer LEVEL_WARN = 2;
    //严重
    public static final Integer LEVEL_SERIOUS = 3;
    //灾难
    public static final Integer LEVEL_DISASTER = 4;


    /**
     * 类型
     */
    //新增
    public static final Integer TYPE_ADD = 1;
    //修改
    public static final Integer TYPE_EDIT = 2;
    //删除
    public static final Integer TYPE_DEL = 3;
    //查询
    public static final Integer TYPE_QUERY = 4;
    //job
    public static final Integer TYPE_JOB = 5;

    public static boolean validata(Log log) {
        return !(StringUtils.isEmpty(log.getId())
                || StringUtils.isEmpty(log.getLevel())
                || StringUtils.isEmpty(log.getType())
                || StringUtils.isEmpty(log.getOperatorDescribe())
                || StringUtils.isEmpty(log.getOperatorUser())
                || StringUtils.isEmpty(log.getOperatorTime())
                || StringUtils.isEmpty(log.getOperatorIp()));
    }
}
