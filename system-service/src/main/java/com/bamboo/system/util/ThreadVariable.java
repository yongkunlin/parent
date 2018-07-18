package com.bamboo.system.util;

import com.bamboo.entity.system.Session;
import com.bamboo.entity.validata.LoginValidata;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程本地变量
 * ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量
 * Created by yklin on 2018/5/21.
 */
public class ThreadVariable {
    private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

    public static void clearThreadVariable() {
        threadLocal.remove();
    }

    public static void setSession(Session session) {
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
        }
        map.put(LoginValidata.LOGIN_SESSION, session);
        threadLocal.set(map);
    }

    public static Session getSession() {
        Map map = (Map) threadLocal.get();
        if (map != null) {
            return (Session) map.get(LoginValidata.LOGIN_SESSION);
        }
        return null;
    }

}
