package com.bamboo.system.mapper;

import com.bamboo.entity.system.Resource;
import com.bamboo.entity.validata.ResourceValidata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 资源持久化
 * Created by yklin on 2018/6/11.
 */
@Mapper
@CacheConfig(cacheNames = ResourceValidata.ENTITY_NAME)
public interface ResourceMapper {

    @Select("SELECT * FROM resource WHERE id = #{id}")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    @Cacheable(key = "#p0")
    Resource getEnitty(@Param("id") String id);

    @Select("SELECT * FROM resource")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    @Cacheable(key = "'all'")
    List<Resource> queryAll();

    @Select("<script>" +
            " SELECT * FROM resource WHERE 1=1 " +
            "<if test='resource != null '>" +
            "<if test='resource.resourceName != null '>" +
            " and resource_name like CONCAT(#{resource.resourceName},'%') " +
            "</if>" +
            "</if>" +
            "</script>")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    List<Resource> queryByPage(@Param("resource")Resource resource);

    @Select("SELECT * FROM resource where parent_id = #{parent_id}")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    @Cacheable(key = "'parentid_'+#p0")
    List<Resource> queryByParentId(@Param("parent_id") String id);
}
