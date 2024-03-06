package com.finace.common.exception;

import com.finace.common.constant.ApiResponseCode;
import com.finace.common.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 全局异常处理，将异常转化为ApiResponse
 */
@Slf4j
@RestControllerAdvice
@SuppressWarnings("NullableProblems")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * 自定义 全局异常处理
     * @return ResponseEntity<ApiResponse>
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception ex) {
        log.info("Exception:", ex);
        // 返回响应对象
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        Map<String, String> errors = new HashMap<>();
        errors.put(ApiResponseCode.SERVICE_ERROR.getMessage(), ex.getMessage());
        apiResponse.error(ApiResponseCode.SERVICE_ERROR.getCode(), errors);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 自定义 参数异常处理
     * @return ResponseEntity
     */
    @ExceptionHandler(ParameterException.class)
    public ResponseEntity<ApiResponse<Object>> apiErrorException(ParameterException parameterException) {
        log.info("ParameterException:", parameterException);
        // 返回响应对象
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        apiResponse.setCodeMessage(parameterException.getMessage());
        apiResponse.error(parameterException.getCode(), parameterException.getFieldErrors());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    /**
     * 自定义 业务处理异常
     * @return ResponseEntity<ApiResponse>
     */
    @ExceptionHandler(BizException.class)
    public ResponseEntity<ApiResponse<Object>> apiErrorException(BizException bizException) {
        log.info("BizException:", bizException);
        // 返回响应对象
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        Map<String, String> errors = new HashMap<>();
        errors.put(ApiResponseCode.BUSINESS_ERROR.getMessage(), bizException.getMessage());
        apiResponse.error(bizException.getCode(), errors);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 自定义 业务处理异常(登录异常)
     *
     * @return ResponseEntity<ApiResponse>
     */
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ApiResponse<Object>> apiErrorException(LoginException bizException) {
        // 返回响应对象
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        Map<String, String> errors = new HashMap<>();
        errors.put(ApiResponseCode.LOGIN_ERROR.getMessage(), bizException.getMessage());
        apiResponse.error(bizException.getCode(), errors);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * BindException异常处理
     * BindException: 作用于@Validated @Valid 注解
     * 仅对于表单提交参数进行异常处理，对于以json格式提交将会失效
     * 只对实体参数进行校验
     * 注：Controller类里面的方法必须加上@Validated 注解
     *
     * @param ex BindException异常信息
     * @return 响应数据
     */
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("BindException:", ex);
        // 返回响应对象
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(p -> {
            errors.put(p.getField(), p.getDefaultMessage());
        });
        apiResponse.error(ApiResponseCode.PARAMETER_INVALID.getCode(), errors);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    /**
     * MethodArgumentNotValidException-Spring封装的参数验证异常处理
     * MethodArgumentNotValidException：作用于 @Validated @Valid 注解， 封装的异常
     *
     * 本项目中，接收参数加上@RequestBody注解（json格式）的异常处理。
     *
     * @param ex MethodArgumentNotValidException异常信息
     * @return 响应数据
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("ParameterException:", ex);
        // 返回响应对象
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(p -> {
            errors.put(p.getField(), p.getDefaultMessage());
        });
        apiResponse.error(ApiResponseCode.PARAMETER_INVALID.getCode(), errors);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    /**
     * ConstraintViolationException-jsr规范中的验证异常，嵌套检验问题
     * ConstraintViolationException：作用于 @NotBlank @NotNull @NotEmpty 注解，校验单个String、Integer、Collection等参数异常处理。
     * 注：Controller类上必须添加@Validated注解，不是加在Controller类的方法上
     * 否则接口单个参数校验无效（RequestParam，PathVariable参数校验）
     *
     * @param ex ConstraintViolationException异常信息
     * @return 响应数据
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> constraintViolationExceptionHandler(ConstraintViolationException ex) {
        log.error("ParameterException:", ex);
        // 返回响应对象
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

        Map<String, String> errors = new HashMap<>();
        violations.forEach(p -> {
            String fieldName = null;
            //获取字段名称（最后一个元素才是）
            Iterator<Path.Node> nodeIterator = p.getPropertyPath().iterator();
            while (nodeIterator.hasNext()) {
                fieldName = nodeIterator.next().getName();
            }
            errors.put(fieldName, p.getMessage());
        });
        apiResponse.error(ApiResponseCode.PARAMETER_INVALID.getCode(), errors);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}