package com.bamboo.system.api;

import com.bamboo.core.base.BaseResoult;
import com.bamboo.core.base.BaseTableVo;
import com.bamboo.core.base.PageVo;
import com.bamboo.entity.system.Role;
import com.bamboo.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 角色
 * Created by yklin on 2018/6/15.
 */
@RestController
@RequestMapping("api/role")
public class RoleApi {
    @Autowired
    @SuppressWarnings("all")
    private RoleService roleService;

    @RequestMapping("all")
    public List<Role> queryAll() {
        return roleService.queryAll();
    }

    /**
     * 分页列表
     *
     * @param role   参数
     * @param pageVo 分页封装类
     * @return
     */
    @RequestMapping("queryByPage")
    public BaseTableVo<Role> queryByPage(Role role, PageVo pageVo) {
        return roleService.queryByPage(role, pageVo);
    }

    /**
     * code唯一校验
     *
     * @param code
     * @return
     */
    @RequestMapping("codeUnique")
    public Boolean codeUnique(String code) {
        if (StringUtils.isEmpty(code)) {
            return false;
        }
        return roleService.codeUnique(code);
    }

    /**
     * 新增或修改
     *
     * @param role
     * @return
     */
    @RequestMapping("saveOrUpdate")
    public Map<String, Object> saveOrUpdate(Role role) {
        if (role == null) {
            return new BaseResoult().getParamErrMap();
        }
        if (StringUtils.isEmpty(role.getId())) {
            roleService.addRole(role);
            return new BaseResoult().getAddSuccessMap();
        } else {
            roleService.updateRole(role);
            return new BaseResoult().getEditSuccessMap();
        }
    }
}
