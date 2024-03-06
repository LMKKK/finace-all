package com.finace.biz.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.finace.biz.dto.form.GetBase64CodeForm;
import com.finace.biz.service.MemberLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.finace.biz.constant.RedisKeyConstant.GRAPHIC_VERIFICATION_CODE;

@Service
@Slf4j
public class MemberLoginServiceImpl implements MemberLoginService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public String getClinetId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public String getBase64Code(GetBase64CodeForm form) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(300, 192, 5, 150);
        String code = lineCaptcha.getCode();
        // 保存验证码到redis中, 15分钟过期
        redisTemplate.opsForValue().set(GRAPHIC_VERIFICATION_CODE + form.getClientId(), code, 15, TimeUnit.MINUTES);
        return lineCaptcha.getImageBase64();
    }
}
