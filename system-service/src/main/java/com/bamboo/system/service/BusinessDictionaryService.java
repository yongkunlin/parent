package com.bamboo.system.service;

import com.bamboo.entity.system.BusinessDictionary;

import java.util.List;

/**
 * 业务字典逻辑接口
 * Created by yklin on 2018/7/19.
 */
public interface BusinessDictionaryService {
    /**
     * 查询所有业务字典
     *
     * @return
     */
    List<BusinessDictionary> queryAll();

    /**
     * 根据层级查询
     * @param dictLevel
     * @return
     */
    List<BusinessDictionary> queryByDictLevel(Integer dictLevel);
}
