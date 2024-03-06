package com.finace.biz.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.finace.biz.dto.form.GetBase64CodeForm;
import com.finace.biz.service.MemberLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class MemberLoginServiceImpl implements MemberLoginService {
    @Override
    public String getClinetId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public String getBase64Code(GetBase64CodeForm form) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(300, 192, 5, 150);
        String code = lineCaptcha.getCode();
        // TODO 保存验证码到redis中
        return lineCaptcha.getImageBase64();
    }
}
