package com.bamboo.system.filter;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 过滤器
 * Created by yklin on 2018/5/25.
 */
@WebFilter(urlPatterns = "/*")
public class BaseFilter implements Filter {

    private static List<Pattern> patterns = new ArrayList<Pattern>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter...");
        patterns.add(Pattern.compile("html/login.html"));
        patterns.add(Pattern.compile("html/register.html"));
        patterns.add(Pattern.compile(".*[(\\.js)||(\\.css)||(\\.png)||(\\.ico)||(\\.html)]"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
//        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
//        if (url.startsWith("/") && url.length() > 1) {
//            url = url.substring(1);
//        }
//        if (!isInclude(url)){
//            System.out.println(url);
//            System.out.println("跳转登录界面");
//            httpResponse.sendRedirect("/html/login.html");
//            return;
//        }
//        servletResponse.setCharacterEncoding("UTF-8");
//        servletResponse.setCharacterEncoding("UTF-8");
//        servletResponse.setContentType("text/html;charset=UTF-8");
        filterChain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter...");
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
