package com.bamboo.system.service.impl;

import com.bamboo.core.base.encapsulation.BaseTableVo;
import com.bamboo.core.base.encapsulation.PageVo;
import com.bamboo.entity.system.Resource;
import com.bamboo.system.mapper.ResourceMapper;
import com.bamboo.system.service.ResourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 逻辑实现
 * Created by yklin on 2018/6/11.
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    @SuppressWarnings("all")
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> queryAll() {
        return resourceMapper.queryAll();
    }

    @Override
    public BaseTableVo<Resource> queryByPage(Resource resource, PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getLimit());
        List<Resource> resources = resourceMapper.queryByPage(resource);
        PageInfo<Resource> pageInfo = new PageInfo<Resource>(resources);
        BaseTableVo<Resource> baseTableVo = new BaseTableVo<>();
        baseTableVo.setCode("0");
        baseTableVo.setMsg("");
        baseTableVo.setCount(pageInfo.getPages());
        baseTableVo.setData(pageInfo.getList());
        return baseTableVo;
    }
}
