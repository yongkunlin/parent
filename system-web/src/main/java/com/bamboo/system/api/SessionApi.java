package com.bamboo.system.api;

import com.bamboo.core.base.api.BaseApi;
import com.bamboo.core.base.constant.GlobalConstants;
import com.bamboo.core.util.VerifyCodeUtil;
import com.bamboo.entity.system.Session;
import com.bamboo.entity.system.User;
import com.bamboo.entity.validator.SessionValidator;
import com.bamboo.entity.validator.UserValidator;
import com.bamboo.system.service.SessionService;
import com.bamboo.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * session
 * Created by yklin on 2018/5/15.
 */
@RestController
@RequestMapping("api/session")
public class SessionApi extends BaseApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param request      请求
     * @param userCode     账号
     * @param password     密码
     * @param validataCode 验证码
     * @return
     */
    @RequestMapping("login")
    public Map<String, Object> login(HttpServletRequest request, String userCode, String password, String validataCode) {
        Map<String, Object> result = new HashMap<>();
        if (!UserValidator.validataUserCodeAndPassword(userCode, password)) {
            result.put("loginType", GlobalConstants.FAILURE);
            result.put("msg", "参数错误");
            return result;
        }
        HttpSession httpSession = request.getSession();
        String sessionCode = (String) httpSession.getAttribute(SessionValidator.LOGIN_CODE);
        if (StringUtils.isEmpty(sessionCode) || !validataCode.equals(sessionCode)) {
            result.put("loginType", GlobalConstants.FAILURE);
            result.put("msg", "验证码错误");
//            return result;
        }
        User user = userService.findUserByUserCode(userCode);
        if (null == user || !user.getPassword().equals(password)) {
            result.put("loginType", GlobalConstants.FAILURE);
            result.put("msg", "账号或密码错误");
            return result;
        }
        Session session = sessionService.addSession(request, user);
        httpSession.setAttribute(SessionValidator.HTTP_SESSION, session);
        result.put("loginType", GlobalConstants.SUCCESS);
        result.put("msg", "登录成功");
        return result;
    }

    /**
     * 获取验证码
     *
     * @param request
     * @return
     */
    @RequestMapping("validataCode")
    public String validataCode(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String vCode = VerifyCodeUtil.getSimpleCode();
        session.setAttribute(SessionValidator.LOGIN_CODE, vCode);
        return vCode;
    }

}
