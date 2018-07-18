package com.bamboo.system.interceptor;

import com.bamboo.entity.system.Session;
import com.bamboo.entity.validata.SessionValidata;
import com.bamboo.system.util.ThreadVariable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 会话拦截
 * Created by yklin on 2018/5/25.
 */
public class SessionInterceptor implements HandlerInterceptor {

    private static  List<Pattern> patterns = new ArrayList<Pattern>();
    static{
        patterns.add(Pattern.compile("api/session/login"));
        patterns.add(Pattern.compile("api/user/register"));
        patterns.add(Pattern.compile("api/session/validataCode"));
    }


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
        if (url.startsWith("/") && url.length() > 1) {
            url = url.substring(1);
        }
        if (isInclude(url)){
            System.out.println("exclude url...");
            return true;
        }
        HttpSession httpSession = httpServletRequest.getSession();
        Session session = (Session) httpSession.getAttribute(SessionValidata.HTTP_SESSION);
        if (null == session) {
            System.out.println("未登录...");
            System.out.println("跳转登录界面");
            httpServletResponse.sendRedirect("/page/login/login.html");
            return false;
        }
        ThreadVariable.setSession(session);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private boolean isInclude(String url) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }
}
