package com.bamboo.system.mapper;

import com.bamboo.entity.system.BusinessDictionary;
import com.bamboo.entity.validator.BusinessDictionaryValidator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by yklin on 2018/7/19.
 */
@Mapper
@CacheConfig(cacheNames = BusinessDictionaryValidator.ENTITY_NAME)
public interface BusinessDictionaryMapper {
    @Select("SELECT * FROM business_dictionary WHERE id = #{id}")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    @Cacheable(key = "#p0")
    BusinessDictionary getEnitty(@Param("id") String id);

    @Select("SELECT * FROM business_dictionary")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    @Cacheable(key = "'all'")
    List<BusinessDictionary> queryAll();

    @Select("SELECT * FROM business_dictionary WHERE dict_level = #{dictLevel}")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    @Cacheable(key = "'dictLevel_'+#p0")
    List<BusinessDictionary> queryByDictLevel(@Param("dictLevel") Integer dictLevel);
}
