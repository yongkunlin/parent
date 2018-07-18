package com.bamboo.mapper;

import com.bamboo.entity.JobTask;
import com.bamboo.entity.validator.JobTaskValidator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * job任务
 * Created by yklin on 2018/7/18.
 */
@Mapper
@CacheConfig(cacheNames = JobTaskValidator.ENTITY_NAME)
public interface JobTaskMapper {
    @Select("SELECT * FROM job_task WHERE id = #{id}")
    @Results({
            @Result(column = "ploy_id", property = "ploy.id")
    })
    @Cacheable(key = "#p0")
    JobTask getEnitty(@Param("id") String id);

    @Select("SELECT * FROM job_task")
    @Results({
            @Result(column = "ploy_id", property = "ploy.id")
    })
    @Cacheable(key = "'all'")
    List<JobTask> queryAll();
}
