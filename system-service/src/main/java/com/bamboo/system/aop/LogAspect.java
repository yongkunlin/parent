package com.bamboo.system.aop;

import com.bamboo.core.base.entity.BaseEntity;
import com.bamboo.entity.validata.LogValidata;
import com.bamboo.core.base.exception.ServiceException;
import com.bamboo.system.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 日志切入
 * Created by yklin on 2018/5/28.
 */
@Aspect
@Repository
public class LogAspect {

    @Autowired
    private LogService logService;

    /**
     * 新增日志
     *
     * @param point
     * @param baseEntity
     */
    @Around("execution(public * com.bamboo.*.mapper.*Mapper.save*(..)) &&  args(baseEntity,..)")
    public void addLog(ProceedingJoinPoint point, BaseEntity baseEntity) {
        System.out.println("into addLog...");
        Object[] args = point.getArgs();//获取连接点方法运行时的入参列表；
        Integer retVal;
        try {
            retVal = (Integer) point.proceed();
            if (1 != retVal) {
                throw new ServiceException("新增失败", this.getClass().getName());
            }
        } catch (Throwable throwable) {
            throw new ServiceException("日志获取返回值失败", this.getClass().getName());
        }
        logService.log(LogValidata.LEVEL_WARN, LogValidata.TYPE_ADD, args[0].toString(), "新增数据", args[0].getClass().getName());
    }

    /**
     * 查询日志
     *
     * @param point
     */
    @Before("execution(public * com.bamboo.*.mapper.*Mapper.get*(..)) " +
            "|| execution(public * com.bamboo.*.mapper.*Mapper.query*(..)) " +
            "|| execution(public * com.bamboo.*.mapper.*Mapper.find*(..))")
    public void queryLog(JoinPoint point) {
        System.out.println("into queryLog...");
        StringBuffer operatorObj = new StringBuffer();
        Object[] args = point.getArgs();//获取连接点方法运行时的入参列表；
        for (Object arg : args) {
            operatorObj.append(arg.toString());
        }
        logService.log(LogValidata.LEVEL_NORMAL, LogValidata.TYPE_QUERY, operatorObj.toString(), "查询数据", null);
    }
}
