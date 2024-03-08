package com.finace.biz.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.finace.biz.constant.RedisKeyConstant;
import com.finace.biz.domain.MemberBindPhone;
import com.finace.biz.dto.form.GetBase64CodeForm;
import com.finace.biz.dto.form.GetSmsCodeForm;
import com.finace.biz.dto.form.SmsCodeResult;
import com.finace.biz.service.MemberBindPhoneService;
import com.finace.biz.service.MemberLoginService;
import com.finace.common.enums.SmsCodeTypeEnum;
import com.finace.common.exception.BizException;
import com.finace.common.exception.ParameterException;
import com.finace.common.utils.DateUtil;
import com.finace.common.utils.MyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.finace.biz.constant.RedisKeyConstant.GRAPHIC_VERIFICATION_CODE;

@Service
@Slf4j
public class MemberLoginServiceImpl implements MemberLoginService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    MemberBindPhoneService memberBindPhoneService;

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
        log.info("客户端id{},图形验证码：{}", form.getClientId(), code);
        return lineCaptcha.getImageBase64();
    }

    @Override
    public void sendSmsCode(GetSmsCodeForm form) {
        // 1. 验证图形验证码
        checkBase64Code(form.getClientId(), form.getCode());
        // 2. 以手机号作为key, 保存验证码到redis中, 15分钟过期
        String key = RedisKeyConstant.SMS_CODE + form.getSmsCodeType() + form.getPhone();
        SmsCodeResult smsCodeResult = (SmsCodeResult) redisTemplate.opsForValue().get(key);
        if (smsCodeResult != null) {
            // 短信验证码每60秒只能获取一次,若60秒内重复获取,则提示用户
            Duration duration = DateUtil.getDuration(smsCodeResult.getGetTime(), DateUtil.getSystemTime());
            if (duration.getSeconds() < 60) {
                throw new BizException("验证码获取太频繁，请稍后重试");
            }
        }
        MemberBindPhone memberBindPhone = memberBindPhoneService.getMemberByPhone(form.getPhone());
        // 如果是注册类型，若已注册，则提示用户
        if (form.getSmsCodeType().equals(SmsCodeTypeEnum.REG.getCode()) && memberBindPhone != null) {
            throw new ParameterException("phone", "该手机号已注册！");
        }
        // 如果是登录类型，若未注册，则提示用户
        if (form.getSmsCodeType().equals(SmsCodeTypeEnum.LOGIN.getCode()) && memberBindPhone == null) {
            throw new ParameterException("phone", "该手机号未注册！");
        }
        // 生成6位随机数
        int smsCode = MyUtil.getRandom(6);
        smsCodeResult = new SmsCodeResult();
        smsCodeResult.setCode(String.valueOf(smsCode));
        smsCodeResult.setGetTime(DateUtil.getSystemTime());
        // 将短信验证码和获取时间保存到redis中, 15分钟过期
        redisTemplate.opsForValue().set(key, smsCodeResult, 15, TimeUnit.MINUTES);
        log.info("客户端id{},手机号：{},短信验证码：{}", form.getClientId(), form.getPhone(), smsCode);
//        TODO 发送短信验证码
//        smsService.sendSmsCode(form.getPhone(), smsCodeResult.getCode(), form.getSmsCodeType());
    }


    @Override
    public boolean checkBase64Code(String clientId, String code) {
        //生成图片，获取base64编码字符串
        String cacheCode = (String) redisTemplate.opsForValue().get(RedisKeyConstant.GRAPHIC_VERIFICATION_CODE + clientId);
        // 校验完成后必须删除
        redisTemplate.delete(RedisKeyConstant.GRAPHIC_VERIFICATION_CODE + clientId);
        if (!code.equalsIgnoreCase(cacheCode)) {
            throw new ParameterException("code", "图形验证码错误！");
        }
        return true;
    }
}
