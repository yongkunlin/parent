package com.bamboo.entity.system;

import com.bamboo.core.base.BaseEntity;

/**
 * 资源
 * Created by yklin on 2018/6/8.
 */
public class Resource extends BaseEntity {
    //资源名称
    private String resourceName;
    //code
    private String resourceCode;
    //路径
    private String url;
    //层级
    private Integer level;
    //状态
    private Integer status;
    //父级
    private Resource parent;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }
}
