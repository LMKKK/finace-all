package com.finace.biz.service;

import com.finace.biz.domain.Member;

public interface MemberService {
    /**
     * 注册
     *
     * @param tenantId 租户id
     * @return 会员id
     */
    long reg(long tenantId);

    /**
     * 获取会员信息
     *
     * @param id
     * @return
     */
    Member get(long id);
}