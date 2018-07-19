package com.bamboo.system.mapper;

import com.bamboo.entity.system.Org;
import com.bamboo.entity.validator.OrgValidator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by yklin on 2018/5/21.
 */
@Mapper
@CacheConfig(cacheNames = OrgValidator.ENTITY_NAME)
public interface OrgMapper {

    @Select("SELECT * FROM org WHERE id = #{id}")
    @Cacheable(key = "#p0")
    Org getEntity(@Param("id") String id);

    @Select("SELECT * FROM org")
    @Cacheable(key = "'all'")
    List<Org> queryAll();

    @Select("SELECT o.* FROM org o INNER JOIN user u ON u.id = #{id} and o.id = u.org_id")
    @Cacheable(key = "'userId_'+#p0")
    Org getOrgByUserId(@Param("id") String id);
}
