package com.finace.common.exception;

import com.finace.common.constant.ApiResponseCode;

/**
 * 基础异常类
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 2612992235262400823L;

    private Integer code = null;

    public BaseException(String message) {
        super(message);
        this.code = ApiResponseCode.SERVICE_ERROR.getCode();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable t) {
        super(message, t);
        this.code = ApiResponseCode.SERVICE_ERROR.getCode();
    }

    public BaseException(Integer code, String message, Throwable t) {
        super(message, t);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
