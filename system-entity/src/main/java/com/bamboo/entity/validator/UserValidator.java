package com.bamboo.entity.validator;


import com.bamboo.entity.system.User;
import org.springframework.util.StringUtils;

/**
 * 用户常量以及校验
 * Created by yklin on 2018/5/15.
 */
public class UserValidator {
    //实体名
    public static final String ENTITY_NAME = "user";
    //注册验证码key
    public static final String REG_CODE = "reg_code";

    public static boolean validataUserCodeAndPassword(String userCode, String password) {
        return !(StringUtils.isEmpty(userCode) || StringUtils.isEmpty(password));
    }

    public static boolean validata(User user) {
        return !(null == user ||
                StringUtils.isEmpty(user.getUserName()) ||
                StringUtils.isEmpty(user.getUserCode()) ||
                StringUtils.isEmpty(user.getPassword()) ||
                null == user.getOrg() ||
                StringUtils.isEmpty(user.getOrg().getId()));
    }

}
