package com.finace.biz.service.impl;

import com.finace.common.constant.CommonConstant;
import com.finace.biz.domain.Member;
import com.finace.biz.mapper.MemberMapper;
import com.finace.biz.service.MemberService;
import com.finace.mybatis.helper.MyBatisWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.finace.biz.domain.MemberField.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    final MemberMapper memberMapper;

    /**
     * 注册
     *
     * @param tenantId 租户id
     * @return 会员id
     */
    @Override
    public long reg(long tenantId) {
        // 注册会员时，需要绑定这个会员所在的租户
        Member member = new Member();
        member.setTenantId(tenantId);
        // 默认是普通会员
        member.setSysRoleIds("[" + CommonConstant.ROLE_MEMBER + "]");
        member.initDefault();
        memberMapper.insert(member);
        return member.getId();
    }

    /**
     * 获取会员信息
     *
     * @param id
     * @return
     */
    @Override
    public Member get(long id) {
        MyBatisWrapper<Member> myBatisWrapper = new MyBatisWrapper<>();
        myBatisWrapper.select(NickName, Id, Disable, Name, AvatarUrl, SysRoleIds,
                        TenantId, Email)
                .whereBuilder().andEq(setId(id));
        return memberMapper.topOne(myBatisWrapper);
    }
}