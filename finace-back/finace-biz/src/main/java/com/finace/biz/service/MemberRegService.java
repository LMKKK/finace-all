package com.finace.biz.service;


import com.finace.biz.dto.form.PhoneRegisterForm;

public interface MemberRegService {

    /**
     * 根据手机号注册
     * 注册 保存到数据库
     *
     * @param form
     * @return
     */
    long phoneReg(PhoneRegisterForm form);

}
