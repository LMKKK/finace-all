package com.finace.biz.service.impl;

import com.finace.biz.domain.MemberBindPhone;
import com.finace.biz.dto.form.PhoneRegisterForm;
import com.finace.biz.service.*;
import com.finace.common.enums.SmsCodeTypeEnum;
import com.finace.common.exception.BizException;
import com.finace.common.exception.ParameterException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Objects;


@Service
@Slf4j
@RequiredArgsConstructor
public class MemberRegServiceImpl implements MemberRegService {
    final MemberLoginService memberLoginService;
    final RedissonClient redissonClient;
    final MemberBindPhoneService memberBindPhoneService;
    final TransactionTemplate transactionTemplate;
    final RedisTemplate<String, Object> redisTemplate;
    final TenantService tenantService;
    final MemberService memberService;


    @Override
    public long phoneReg(PhoneRegisterForm request) {
        // 1. 校验两次密码是否一致
        if (!Objects.equals(request.getPassword(), request.getConfirmPassword())) {
            throw new ParameterException("两次输入的密码不一致");
        }
        // 2. 校验短信验证码
        memberLoginService.checkSmsCode(request.getPhone(), request.getSmsCode(), SmsCodeTypeEnum.REG.getCode());
        // 3. 分布式锁，防止并发注册
        RLock rLock = redissonClient.getLock("PHONE_REG:" + request.getPhone());
        try {
            rLock.lock();
            // 4. 校验手机号是否已注册,必须放在分布式锁内,防止并发注册
            MemberBindPhone memberBindPhone = memberBindPhoneService.getMemberByPhone(request.getPhone());
            if (memberBindPhone != null) {
                log.warn("手机号：{}已注册", request.getPhone());
                throw new BizException("手机号已注册");
            }
            //将游客数据入口（保证数据一致性）
            // 5. 插入表中: 租户表、会员表、会员绑定手机号表, 事务控制
            Long memberId = transactionTemplate.execute(transactionStatus -> {
                // 5.1 创建租户
                long tenantId = tenantService.add();
                // 5.2 创建会员
                long id = memberService.reg(tenantId);
                if (id <= 0) {
                    throw new BizException("注册异常");
                }
                // 5.3 会员绑定手机号,方便手机号注册
                memberBindPhoneService.reg(request.getPhone(), id, request.getPassword());
                return id;
            });
            if (memberId == null) {
                throw new BizException("注册失败");
            }
            return memberId;
        } catch (Exception ex) {
            throw new BizException("注册失败", ex);
        } finally {
            // 切记释放锁
            rLock.unlock();
        }
    }

    /**
     * 生成微信公众号二维码 用于关注注册
     *
     * @param clientId
     * @return
     */

}
