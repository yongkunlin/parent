package com.bamboo.system.mapper;

import com.bamboo.entity.system.Log;
import com.bamboo.entity.validator.LogValidator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;

/**
 * 日志持久化
 * Created by yklin on 2018/5/28.
 */
@Mapper
@CacheConfig(cacheNames = LogValidator.ENTITY_NAME)
public interface LogMapper {

    @Insert("INSERT INTO log Values(#{log.id},#{log.level},#{log.type},#{log.operatorObj},#{log.operatorDescribe}" +
            ",#{log.modle},#{log.operatorUser},#{log.operatorTime},#{log.operatorIp})")
    @CacheEvict(key = "'all'")
    int saveEntity(@Param("log") Log log);
}
