package com.bamboo.core.base.encapsulation;

/**
 * 分页基础封装类
 * Created by yklin on 2018/6/15.
 */
public class PageVo {

    private Integer page;

    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
