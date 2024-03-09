package com.finace.admin.api.controller;

import com.finace.biz.dto.form.PhoneRegisterForm;
import com.finace.biz.service.MemberRegService;
import com.finace.common.dto.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "注册模块")
@RestController
@RequestMapping(value = "/reg")
@RequiredArgsConstructor
@Slf4j
public class RegController {
    final MemberRegService memberRegService;

    @ApiOperation(value = "手机号注册")
    @PostMapping(value = "/phoneReg")
    public ApiResponse<Long> phoneReg(@Validated @RequestBody PhoneRegisterForm form) {
        long result = memberRegService.phoneReg(form);
        return ApiResponse.success(result);
    }

}