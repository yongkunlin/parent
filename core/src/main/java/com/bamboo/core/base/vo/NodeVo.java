package com.bamboo.core.base.vo;

import java.util.List;

/**
 * 属性网格封装类
 * Created by yklin on 2018/7/24.
 */
public class NodeVo<T> {

    //当前节点id
    private String nodeId;
    //父节点id
    private String pid;
    //节点对象
    private T entity;
    //子节点
    private List<NodeVo> nodes;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public List<NodeVo> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeVo> nodes) {
        this.nodes = nodes;
    }
}
