package com.bamboo.system.api;

import com.bamboo.core.base.api.BaseApi;
import com.bamboo.core.base.vo.NodeVo;
import com.bamboo.entity.system.BusinessDictionary;
import com.bamboo.system.service.BusinessDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务字典
 * Created by yklin on 2018/7/19.
 */
@RestController
@RequestMapping("api/businessDictionary")
public class BusinessDictionaryApi extends BaseApi {

    @Autowired
    private BusinessDictionaryService businessDictionaryService;

    /**
     * 查询所有数据
     *
     * @return
     */
    @GetMapping("all")
    public List<BusinessDictionary> queryAll() {
        return businessDictionaryService.queryAll();
    }

    /**
     * 分页筛选查询
     * 并封装为treeTable格式
     *
     * @param businessDictionary
     * @return
     */
    @RequestMapping("queryByFirst")
    public List<NodeVo<BusinessDictionary>> queryByFirst(BusinessDictionary businessDictionary) {
        List<BusinessDictionary> businessDictionaries = businessDictionaryService.queryByDictLevel(1);
        return parseNodeVo(businessDictionaries);
    }

    /**
     * treetable 封装
     *
     * @param businessDictionaries
     * @return
     */
    private List<NodeVo<BusinessDictionary>> parseNodeVo(List<BusinessDictionary> businessDictionaries) {
        List<NodeVo<BusinessDictionary>> nodeVos = new ArrayList<>();
        for (BusinessDictionary businessDictionary : businessDictionaries) {
            NodeVo<BusinessDictionary> nodeVo = new NodeVo<BusinessDictionary>();
            nodeVo.setNodeId(businessDictionary.getId());
            nodeVo.setPid(businessDictionary.getDictParent().getId());
            nodeVo.setEntity(businessDictionary);
            nodeVos.add(nodeVo);
        }
        return nodeVos;
    }
}
