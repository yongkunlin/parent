package com.bamboo.system.service.impl;

import com.bamboo.entity.system.BusinessDictionary;
import com.bamboo.system.mapper.BusinessDictionaryMapper;
import com.bamboo.system.service.BusinessDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务字典逻辑
 * Created by yklin on 2018/7/19.
 */
@Service
public class BusinessDictionaryServiceImpl implements BusinessDictionaryService {

    @Autowired
    @SuppressWarnings("all")
    private BusinessDictionaryMapper businessDictionaryMapper;

    @Override
    public List<BusinessDictionary> queryAll() {
        return businessDictionaryMapper.queryAll();
    }

    @Override
    public List<BusinessDictionary> queryByDictLevel(Integer dictLevel) {
        return businessDictionaryMapper.queryByDictLevel(dictLevel);
    }

}
