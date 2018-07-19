package com.bamboo.system.api;

import com.bamboo.core.base.api.BaseApi;
import com.bamboo.core.base.constant.GlobalConstants;
import com.bamboo.core.util.VerifyCodeUtil;
import com.bamboo.entity.system.Org;
import com.bamboo.entity.system.User;
import com.bamboo.entity.validator.UserValidator;
import com.bamboo.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户
 * Created by yklin on 2018/4/28.
 */
@RestController
@RequestMapping("api/user")
public class UserApi extends BaseApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     * 扩展
     *
     * @param id
     * @return
     */
    @RequestMapping("{id}")
    public User expand(@PathVariable String id) {
        return userService.expand(id);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping("all")
    public List<User> queryAll() {
        List<User> users = userService.queryAll();
        return users;
    }

    @RequestMapping("findUserByUserCode")
    public Map<String, Object> findUserByUserCode(String userCode) {
        Map<String, Object> result = new HashMap<>();
        if (StringUtils.isEmpty(userCode)) {
            result.put(GlobalConstants.RESULT_STATE, GlobalConstants.FAILURE);
            result.put(GlobalConstants.RESULT_MSG, GlobalConstants.MSG_ERR);
            return result;
        }
        User user = userService.findUserByUserCode(userCode);
        if (null == user) {
            result.put(GlobalConstants.RESULT_STATE, GlobalConstants.FAILURE);
            result.put(GlobalConstants.RESULT_MSG, user);
            return result;
        }
        result.put(GlobalConstants.RESULT_STATE, GlobalConstants.SUCCESS);
        result.put(GlobalConstants.RESULT_MSG, user);
        return result;
    }

    /**
     * 用户注册
     *
     * @return
     */
    @RequestMapping("register")
    public Map<String, Object> register(HttpServletRequest request, User user, String validataCode) {
        Map<String, Object> result = new HashMap<>();
//        模拟
        Org org = new Org();
        org.setId("1");
        user.setOrg(org);
        if (!UserValidator.validata(user)) {
            result.put(GlobalConstants.RESULT_STATE, GlobalConstants.FAILURE);
            result.put(GlobalConstants.RESULT_MSG, GlobalConstants.MSG_ERR);
            return result;
        }
        HttpSession httpSession = request.getSession();
        String sessionCode = (String) httpSession.getAttribute(UserValidator.REG_CODE);
        if (StringUtils.isEmpty(sessionCode) || !validataCode.equals(sessionCode)) {
            result.put(GlobalConstants.RESULT_STATE, GlobalConstants.FAILURE);
            result.put(GlobalConstants.RESULT_MSG, "验证码错误");
//            return result;
        }
        userService.register(user);
        result.put(GlobalConstants.RESULT_STATE, GlobalConstants.SUCCESS);
        result.put(GlobalConstants.RESULT_MSG, GlobalConstants.MSG_SUCCESS_ADD);
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
        session.setAttribute(UserValidator.REG_CODE, vCode);
        return vCode;
    }
}
