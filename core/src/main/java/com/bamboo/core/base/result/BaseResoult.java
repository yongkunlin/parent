package com.bamboo.core.base.result;

import java.util.HashMap;
import java.util.Map;

import static com.bamboo.core.base.constant.GlobalConstants.FAILURE;
import static com.bamboo.core.base.constant.GlobalConstants.MSG_ERR;
import static com.bamboo.core.base.constant.GlobalConstants.MSG_SUCCESS_ADD;
import static com.bamboo.core.base.constant.GlobalConstants.MSG_SUCCESS_EDIT;
import static com.bamboo.core.base.constant.GlobalConstants.RESULT_MSG;
import static com.bamboo.core.base.constant.GlobalConstants.RESULT_STATE;
import static com.bamboo.core.base.constant.GlobalConstants.SUCCESS;

/**
 * 返回值map基础封装
 * Created by yklin on 2018/6/19.
 */
public class BaseResoult {

    /**
     * 参数错误返回信息
     */
    private Map<String, Object> paramErrMap = new HashMap<>();

    /**
     * 新增成功返回信息
     */
    private Map<String, Object> addSuccessMap = new HashMap<>();

    /**
     * 编辑成功返回信息
     */
    private Map<String, Object> editSuccessMap = new HashMap<>();

    public BaseResoult() {
        initResoult();
    }

    public Map<String, Object> getParamErrMap() {
        return paramErrMap;
    }

    public Map<String, Object> getAddSuccessMap() {
        return addSuccessMap;
    }

    public Map<String, Object> getEditSuccessMap() {
        return editSuccessMap;
    }

    private void initResoult() {
        paramErrMap.put(RESULT_STATE, FAILURE);
        paramErrMap.put(RESULT_MSG, MSG_ERR);

        addSuccessMap.put(RESULT_STATE, SUCCESS);
        addSuccessMap.put(RESULT_MSG, MSG_SUCCESS_ADD);

        editSuccessMap.put(RESULT_STATE, SUCCESS);
        editSuccessMap.put(RESULT_MSG, MSG_SUCCESS_EDIT);
    }
}
