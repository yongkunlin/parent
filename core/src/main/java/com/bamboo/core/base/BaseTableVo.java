package com.bamboo.core.base;

import java.util.List;

/**
 * 基础封装类
 * Created by yklin on 2018/6/14.
 */
public class BaseTableVo<T> {

    private String code;

    private String msg;

    //条数
    private Integer count;

    //数据
    private List<T> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
