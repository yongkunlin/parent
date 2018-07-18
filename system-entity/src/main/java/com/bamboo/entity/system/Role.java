package com.bamboo.entity.system;

import com.bamboo.core.base.BaseEntity;

import java.util.List;

/**
 * 角色
 * Created by yklin on 2018/6/15.
 */
public class Role extends BaseEntity {

    //角色名
    private String roleName;

    //code
    private String roleCode;

    //层级
    private Integer level;

    //状态
    private Integer status;

    //父级
    private Role parent;

    private List<Resource> resources;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Role getParent() {
        return parent;
    }

    public void setParent(Role parent) {
        this.parent = parent;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
