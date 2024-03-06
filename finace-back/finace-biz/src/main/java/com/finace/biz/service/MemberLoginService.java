package com.finace.biz.service;

import com.finace.biz.dto.form.GetBase64CodeForm;

public interface MemberLoginService {

    /**
     * 获取客户端id，用于标识客户端身份
     * @return
     */
    String getClinetId();

    /**
     * 获取图形验证码
     * @param clientId
     * @return
     */
    String getBase64Code(GetBase64CodeForm form);

}
