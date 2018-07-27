package com.bamboo.feign.system.client;

import com.bamboo.entity.system.BusinessDictionary;
import com.bamboo.feign.system.client.fallback.BusinessDictionaryFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 业务字典
 * Created by yklin on 2018/7/27.
 */
@FeignClient(value = "system-web", fallback = BusinessDictionaryFallBack.class)
public interface BusinessDictionaryClient {

    @RequestMapping("api/businessDictionary/all")
    List<BusinessDictionary> queryAll();
}
