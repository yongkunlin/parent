package com.bamboo.entity.system;

import com.bamboo.core.base.entity.BaseEntity;

/**
 * 部门
 * Created by yklin on 2018/5/21.
 */
public class Org extends BaseEntity {
    //    名称
    private String orgName;
    //    编码
    private String orgCode;
    //    层次
    private Integer orgLevel;
    //    父id
    private String parentId;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
