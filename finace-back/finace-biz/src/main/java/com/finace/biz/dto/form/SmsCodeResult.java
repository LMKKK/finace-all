package com.finace.biz.dto.form;

import lombok.Data;

import java.util.Date;

@Data
public class SmsCodeResult {
    /**
     * 短信验证码
     */
    private String code;
    /**
     * 短信验证码存储到redis的时间
     */
    private Date getTime;
}