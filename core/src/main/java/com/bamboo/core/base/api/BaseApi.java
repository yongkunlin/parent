package com.bamboo.core.base.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 基础api封装
 * Created by yklin on 2018/4/28.
 */
abstract public class BaseApi implements Api {
    protected Log log = LogFactory.getLog(this.getClass());
}
