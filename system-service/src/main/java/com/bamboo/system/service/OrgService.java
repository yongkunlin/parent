package com.bamboo.system.service;

import com.bamboo.entity.system.Org;

import java.util.List;

/**
 * 部门
 * Created by yklin on 2018/5/21.
 */
public interface OrgService {

    /**
     * 扩展
     *
     * @param id
     * @return
     */
    Org expand(String id);

    /**
     * 查询所有部门
     *
     * @return
     */
    List<Org> queryAll();

    /**
     * 根据用户id查询部门
     *
     * @param userId
     * @return
     */
    Org findOrgByUserId(String userId);
}
