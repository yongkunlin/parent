package com.bamboo.system.service.impl;

import com.bamboo.entity.system.Org;
import com.bamboo.core.base.exception.ServiceException;
import com.bamboo.system.mapper.OrgMapper;
import com.bamboo.system.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 逻辑实现
 * Created by yklin on 2018/5/21.
 */
@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    @SuppressWarnings("all")
    private OrgMapper orgMapper;

    @Override
    public Org expand(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new ServiceException("参数错误", this.getClass().getName());
        }
        return orgMapper.getEntity(id);
    }

    @Override
    public List<Org> queryAll() {
        return orgMapper.queryAll();
    }

    @Override
    public Org findOrgByUserId(String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new ServiceException("参数错误", this.getClass().getName());
        }
        return orgMapper.getOrgByUserId(userId);
    }
}
