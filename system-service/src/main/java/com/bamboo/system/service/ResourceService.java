package com.bamboo.system.service;

import com.bamboo.core.base.encapsulation.BaseTableVo;
import com.bamboo.core.base.encapsulation.PageVo;
import com.bamboo.entity.system.Resource;

import java.util.List;

/**
 * 资源逻辑接口
 * Created by yklin on 2018/6/11.
 */
public interface ResourceService {
    /**
     * 查询所有资源
     *
     * @return
     */
    List<Resource> queryAll();

    /**
     * 分页查询
     *
     * @param resource
     * @param pageVo
     * @return
     */
    BaseTableVo<Resource> queryByPage(Resource resource, PageVo pageVo);
}
