package com.finace.admin.api.controller;

import com.finace.biz.dto.form.GetBase64CodeForm;
import com.finace.biz.service.MemberLoginService;
import com.finace.common.dto.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户登录模块")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    MemberLoginService memberLoginService;

    @ApiOperation("获取客户端ID")
    @GetMapping("/getClientId")
    public ApiResponse<String> getClientId() {
        String result = memberLoginService.getClinetId();
        return ApiResponse.success(result);
    }


    @ApiOperation("获取图形验证码")
    @GetMapping("/getBase64Code")
    public ApiResponse<String> getBase64Code(@Validated @ModelAttribute GetBase64CodeForm form) {
        String base64Code = memberLoginService.getBase64Code(form);
        return ApiResponse.success(base64Code);
    }
}
