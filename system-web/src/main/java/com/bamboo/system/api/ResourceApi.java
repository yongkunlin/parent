package com.bamboo.system.api;

import com.bamboo.core.base.encapsulation.BaseTableVo;
import com.bamboo.core.base.encapsulation.PageVo;
import com.bamboo.entity.system.Resource;
import com.bamboo.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 资源
 * Created by yklin on 2018/6/11.
 */
@RestController
@RequestMapping("api/resource")
public class ResourceApi {
    @Autowired
    @SuppressWarnings("all")
    private ResourceService resourceService;

    @RequestMapping("all")
    public List<Resource> queryAll() {
        List<Resource> resources = resourceService.queryAll();
        return resources;
    }

    /**
     * 分页列表
     *
     * @param resource
     * @param pageVo
     * @return
     */
    @RequestMapping("queryByPage")
    public BaseTableVo<Resource> queryByPage(Resource resource, PageVo pageVo) {
        return resourceService.queryByPage(resource,pageVo);
    }
}
