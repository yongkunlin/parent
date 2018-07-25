package com.bamboo.entity.system;

import com.bamboo.core.base.entity.BaseEntity;

/**
 * 业务字典
 * Created by yklin on 2018/7/19.
 */
public class BusinessDictionary extends BaseEntity {

    //code
    private String dictCode;

    //名称
    private String dictName;

    //值
    private Integer dictValue;

    //排序
    private Integer dictSeq;

    //层级
    private Integer dictLevel;

    //备注
    private String dictRemark;

    //所属系统
    private String dictSystem;

    //父节点
    private BusinessDictionary dictParent;

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public Integer getDictValue() {
        return dictValue;
    }

    public void setDictValue(Integer dictValue) {
        this.dictValue = dictValue;
    }

    public Integer getDictSeq() {
        return dictSeq;
    }

    public void setDictSeq(Integer dictSeq) {
        this.dictSeq = dictSeq;
    }

    public Integer getDictLevel() {
        return dictLevel;
    }

    public void setDictLevel(Integer dictLevel) {
        this.dictLevel = dictLevel;
    }

    public String getDictRemark() {
        return dictRemark;
    }

    public void setDictRemark(String dictRemark) {
        this.dictRemark = dictRemark;
    }

    public String getDictSystem() {
        return dictSystem;
    }

    public void setDictSystem(String dictSystem) {
        this.dictSystem = dictSystem;
    }

    public BusinessDictionary getDictParent() {
        return dictParent;
    }

    public void setDictParent(BusinessDictionary dictParent) {
        this.dictParent = dictParent;
    }
}
