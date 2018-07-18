package com.bamboo.system.service.impl;

import com.bamboo.core.base.encapsulation.BaseTableVo;
import com.bamboo.core.base.encapsulation.PageVo;
import com.bamboo.core.util.UUIDUtil;
import com.bamboo.entity.system.Role;
import com.bamboo.core.base.exception.ServiceException;
import com.bamboo.system.mapper.RoleMapper;
import com.bamboo.system.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 角色逻辑
 * Created by yklin on 2018/6/15.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    @SuppressWarnings("all")
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryAll() {
        return roleMapper.queryAll();
    }

    @Override
    public BaseTableVo<Role> queryByPage(Role role, PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getLimit());
        List<Role> resources = roleMapper.queryByPage(role);
        PageInfo<Role> pageInfo = new PageInfo<>(resources);
        BaseTableVo<Role> baseTableVo = new BaseTableVo<>();
        baseTableVo.setCode("0");
        baseTableVo.setMsg("");
        baseTableVo.setCount(pageInfo.getPages());
        baseTableVo.setData(pageInfo.getList());
        return baseTableVo;
    }

    @Override
    public Boolean codeUnique(String code) {
        Role role = roleMapper.findByCode(code);
        return role == null;
    }

    @Override
    public void addRole(Role role) {
        try {
            role.setId(UUIDUtil.get32UpperCase());
            role.setParent(new Role());
            saveRole(role);
        } catch (Exception e) {
            throw new ServiceException("添加角色失败", this.getClass().getName());
        }
    }

    @Override
    public void updateRole(Role role) {

    }

    private void saveRole(Role role) {
        if (null == role || StringUtils.isEmpty(role.getId())) {
            throw new ServiceException("参数错误", this.getClass().getName());
        }
        try {
            roleMapper.saveEntity(role);
        } catch (Exception e) {
            throw new ServiceException("新增错误", this.getClass().getName(), e);
        }
    }
}
