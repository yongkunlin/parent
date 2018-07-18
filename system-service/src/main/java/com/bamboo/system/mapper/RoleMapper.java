package com.bamboo.system.mapper;

import com.bamboo.entity.system.Role;
import com.bamboo.entity.validata.RoleValidata;
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
 * 角色持久化
 * Created by yklin on 2018/6/15.
 */
@Mapper
@CacheConfig(cacheNames = RoleValidata.ENTITY_NAME)
public interface RoleMapper {

    @Select("SELECT * FROM role WHERE id = #{id}")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    @Cacheable(key = "#p0")
    Role getEnitty(@Param("id") String id);

    @Select("SELECT * FROM role")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    @Cacheable(key = "'all'")
    List<Role> queryAll();

    @Select("<script>" +
            " SELECT * FROM role WHERE 1=1 " +
            "<if test='obj != null '>" +
            "<if test='obj.roleName != null '>" +
            " and role_name like CONCAT(#{obj.roleName},'%') " +
            "</if>" +
            "</if>" +
            "</script>")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    List<Role> queryByPage(@Param("obj") Role obj);

    @Select("SELECT * FROM role where parent_id = #{parent_id}")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    @Cacheable(key = "'parentid_'+#p0")
    List<Role> queryByParentId(@Param("parent_id") String id);

    @Select("SELECT * FROM role WHERE role_code = #{code}")
    @Results({
            @Result(column = "parent_id", property = "parent.id")
    })
    @Cacheable(key = "'code_'+#p0")
    Role findByCode(@Param("code") String code);

    @Insert("INSERT INTO role Values(#{role.id},#{role.roleName},#{role.roleCode},#{role.level},#{role.status},#{role.parent.id}" +
            ",#{role.createUser},#{role.createDate},#{role.createIp}" +
            ",#{role.updateUser},#{role.updateDate},#{role.updateIp}" +
            ",#{role.deleteUser},#{role.deleteDate},#{role.deleteIp}" +
            ",#{role.izDelete},#{role.version})")
    @CacheEvict(key = "'all'")
    Integer saveEntity(@Param("role") Role role);
}
