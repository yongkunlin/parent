package com.bamboo.system.mapper;

import com.bamboo.entity.system.User;
import com.bamboo.entity.validata.UserValidata;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 用户数据操作
 * Created by yklin on 2018/4/28.
 */
@Mapper
//配置了该数据访问对象中返回的内容将存储于名为users的缓存对象中
@CacheConfig(cacheNames = UserValidata.ENTITY_NAME)
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(column = "org_id", property = "org.id")
    })
    @Cacheable(key = "#p0")
    User getEnitty(@Param("id") String id);

    @Select("SELECT * FROM user")
    @Results({
            @Result(column = "org_id", property = "org.id")
    })
    @Cacheable(key = "'all'")
    List<User> queryAll();

    @Select("SELECT * FROM user WHERE user_code = #{userCode} and password = #{password}")
    @Results({
            @Result(column = "org_id", property = "org.id")
    })
    @Cacheable(key = "#p0+#p1")
    User findUserByUserCodeAndPassword(@Param("userCode") String userCode, @Param("password") String password);

    @Select("SELECT * FROM user WHERE user_code = #{userCode}")
    @Results({
            @Result(column = "org_id", property = "org.id")
    })
    @Cacheable(key = "#p0")
    User findUserByUserCode(@Param("userCode") String userCode);

    @Insert("INSERT INTO user Values(#{user.id},#{user.userName},#{user.userCode},#{user.password},#{user.org.id}" +
            ",#{user.createUser},#{user.createDate},#{user.createIp}" +
            ",#{user.updateUser},#{user.updateDate},#{user.updateIp}" +
            ",#{user.deleteUser},#{user.deleteDate},#{user.deleteIp}" +
            ",#{user.izDelete},#{user.version})")
    @CacheEvict(key = "'all'")
    Integer saveEntity(@Param("user")User user);
}
