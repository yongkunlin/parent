package com.bamboo.core.base.exception;

/**
 * 捕获
 * Created by yklin on 2018/7/19.
 */
public class CatchException {

    private String name;

    private Integer code;

    private Exception exception;

    public CatchException(String name, Integer code, Exception exception) {
        this.name = name;
        this.code = code;
        this.exception = exception;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
