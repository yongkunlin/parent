package com.bamboo.system.exception;

import com.bamboo.core.base.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务异常封装
 * Created by yklin on 2018/5/28.
 */
public class ServiceException extends BaseException {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ServiceException() {
        super();
    }

    public ServiceException(String message, String methodName) {
        super(message);
        logger.error(methodName + ":{}", message);
    }

    public ServiceException(String message, String methodName, Throwable cause) {
        super(message, cause);
        logger.error(methodName + ":{}", processTrace(cause));
    }

    private String processTrace(Throwable e) {
        if (null != e && e.getStackTrace() != null) {
            StackTraceElement stackTraceElement = e.getStackTrace()[0];
            StringBuffer sb = new StringBuffer();
            sb.append("--error messag detail：").append(e.toString()).append(",").append("file=")
                    .append(stackTraceElement.getFileName()).append(",").append("line=")
                    .append(stackTraceElement.getLineNumber()).append(",").append("method=")
                    .append(stackTraceElement.getMethodName());
            return sb.toString();
        }
        return null;
    }
}
