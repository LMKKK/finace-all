package com.finace.common.dto;

import com.finace.common.constant.ApiResponseCode;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ApiResponse<T> {
    private T data;
    private Integer code = 0;
    private String codeMessage;
    private Map<String, String> errorMessage;
    private Boolean success = true;

    public static <T> ApiResponse<T> success() {
        return success(null);
    }

    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(data);
        response.setCode(ApiResponseCode.SUCCESS.getCode());
        response.setCodeMessage(ApiResponseCode.SUCCESS.getMessage());
        response.setSuccess(true);
        return response;
    }

    public static <T> ApiResponse<T> error(Map<String, String> errors) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(null);
        response.setCode(ApiResponseCode.SERVICE_ERROR.getCode());
        response.setCodeMessage(ApiResponseCode.SERVICE_ERROR.getMessage());
        response.setErrorMessage(errors);
        response.setSuccess(false);
        return response;
    }

    public static <T> ApiResponse<T> error(String error) {
        Map<String, String> errors = new HashMap<>();
        errors.put(error, error);
        return error(errors);
    }


    public ApiResponse<T> error(String msg, T data) {
        this.setData(data);
        this.setSuccess(false);
        this.setCode(ApiResponseCode.SERVICE_ERROR.getCode());
        this.setCodeMessage(ApiResponseCode.SERVICE_ERROR.getMessage());
        return this;
    }

    public ApiResponse<T> error(Integer code, Map<String, String> errors) {
        this.setCode(code);
        this.setErrorMessage(errors);
        this.setData(data);
        this.setSuccess(false);
        return this;
    }
}
