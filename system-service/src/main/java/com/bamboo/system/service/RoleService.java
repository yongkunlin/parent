package com.bamboo.system.service;

import com.bamboo.core.base.BaseTableVo;
import com.bamboo.core.base.PageVo;
import com.bamboo.entity.system.Role;

import java.util.List;

/**
 * 角色接口
 * Created by yklin on 2018/6/15.
 */
public interface RoleService {
    /**
     * 查询所有资源
     *
     * @return
     */
    List<Role> queryAll();

    /**
     * 分页查询
     *
     * @param role
     * @param pageVo
     * @return
     */
    BaseTableVo<Role> queryByPage(Role role, PageVo pageVo);

    /**
     * code唯一校验
     *
     * @param code
     * @return
     */
    Boolean codeUnique(String code);

    /**
     * 添加角色
     *
     * @param role
     */
    void addRole(Role role);

    /**
     * 修改角色
     *
     * @param role
     */
    void updateRole(Role role);
}
