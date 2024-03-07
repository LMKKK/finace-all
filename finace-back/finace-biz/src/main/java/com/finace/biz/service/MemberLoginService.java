package com.finace.biz.service;

import com.finace.biz.dto.form.GetBase64CodeForm;
import com.finace.biz.dto.form.GetSmsCodeForm;

public interface MemberLoginService {

    /**
     * 获取客户端id，用于标识客户端身份
     * @return
     */
    String getClinetId();

    /**
     * 获取图形验证码
     *
     * @param clientId
     * @return
     */
    String getBase64Code(GetBase64CodeForm form);


    /**
     * 发送短信验证码
     *
     * @param form
     */
    void sendSmsCode(GetSmsCodeForm form);

    /**
     * 校验图形验证码
     *
     * @param clientId
     * @param code
     * @return
     */
    boolean checkBase64Code(String clientId, String code);
}
