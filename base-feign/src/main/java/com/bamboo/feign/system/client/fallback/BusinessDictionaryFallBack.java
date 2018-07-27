package com.bamboo.feign.system.client.fallback;

import com.bamboo.entity.system.BusinessDictionary;
import com.bamboo.feign.system.client.BusinessDictionaryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 业务字典
 * Created by yklin on 2018/7/27.
 */
@Component
public class BusinessDictionaryFallBack implements BusinessDictionaryClient {
    @Override
    public List<BusinessDictionary> queryAll() {
        System.out.println("err");
        return null;
    }
}
