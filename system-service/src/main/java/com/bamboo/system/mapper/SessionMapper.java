package com.bamboo.system.mapper;

import com.bamboo.entity.system.Session;
import com.bamboo.entity.validator.SessionValidator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * session持久化
 * Created by yklin on 2018/5/21.
 */
@Mapper
@CacheConfig(cacheNames = SessionValidator.ENTITY_NAME)
public interface SessionMapper {

    @Select("SELECT * FROM session WHERE id = #{id}")
    @Cacheable(key = "#p0")
    Session getEntity(@Param("id") String id);

    @Select("SELECT * FROM session")
    @Cacheable(key = "'all'")
    List<Session> queryAll();

    @Select("SELECT * FROM session WHERE user_id = #{id}")
    @Cacheable(key = "'userId_'+#p0")
    Session getSessionByUserId(@Param("id") String id);

    @Insert("insert into session(id,user_id,org_id,access_ip,access_time,access_url,state) " +
            "values(#{id},#{user.id},#{org.id},#{accessIp},#{accessTime},#{accessUrl},#{state});")
    @CacheEvict(key = "'all'")
    int saveEntity(Session session);

    @Update("update session set state = #{state}")
    @CachePut(key = "'userId_'+#p0")
    int updateSessionStateByUserId(@Param("userId") String userId, @Param("state") Integer state);
}
