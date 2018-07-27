package com.bamboo.feign.system.controller;

import com.bamboo.entity.system.BusinessDictionary;
import com.bamboo.feign.system.client.BusinessDictionaryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 业务字典
 * Created by yklin on 2018/7/27.
 */
@Controller
@RequestMapping("businessDictionary")
public class BusinessDictionaryController {

    @Autowired
    @SuppressWarnings("all")
    private BusinessDictionaryClient businessDictionaryClient;

    @RequestMapping("all")
    @ResponseBody
    public List<BusinessDictionary> queryAll() {
        return businessDictionaryClient.queryAll();
    }

}
