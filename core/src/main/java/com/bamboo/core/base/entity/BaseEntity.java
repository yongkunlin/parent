package com.bamboo.core.base.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础字段
 * Created by yklin on 2018/4/28.
 */
abstract public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //    主键
    private String id;
    //    创建人
    private String createUser;
    //    创建时间
    private Date createDate;
    //    创建ip
    private String createIp;
    //    修改人
    private String updateUser;
    //    修改时间
    private Date updateDate;
    //    修改ip
    private String updateIp;
    //    删除人
    private String deleteUser;
    //    删除时间
    private Date deleteDate;
    //    删除ip
    private String deleteIp;
    //    是否删除
    private Integer izDelete;
    //    版本
    private Integer version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateIp() {
        return updateIp;
    }

    public void setUpdateIp(String updateIp) {
        this.updateIp = updateIp;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getDeleteIp() {
        return deleteIp;
    }

    public void setDeleteIp(String deleteIp) {
        this.deleteIp = deleteIp;
    }

    public Integer getIzDelete() {
        return izDelete;
    }

    public void setIzDelete(Integer izDelete) {
        this.izDelete = izDelete;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
