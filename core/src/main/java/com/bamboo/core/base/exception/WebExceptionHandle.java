package com.bamboo.core.base.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常捕捉
 * Created by yklin on 2018/7/18.
 */
@ControllerAdvice
@ResponseBody
public class WebExceptionHandle {
    private static Logger logger = LoggerFactory.getLogger(WebExceptionHandle.class);

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("result", "400 - Bad Request");
        return responseMap;
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String, Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("result", "405 - Method Not Allowed");
        return responseMap;
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Map<String, Object> handleHttpMediaTypeNotSupportedException(Exception e) {
        logger.error("不支持当前媒体类型", e);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("result", "Unsupported Media Type");
        return responseMap;
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception e) {
        Map<String, Object> responseMap = new HashMap<>();
        if (e instanceof ServiceException) {
            responseMap.put("result", "500 - Internal Server Error");
        }
        logger.error("服务运行异常", e);
        e.printStackTrace();
        return responseMap;
    }
}
