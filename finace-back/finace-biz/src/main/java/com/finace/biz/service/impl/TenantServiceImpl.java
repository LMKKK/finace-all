package com.finace.biz.service.impl;

import com.finace.biz.domain.Tenant;
import com.finace.biz.mapper.TenantMapper;
import com.finace.biz.service.TenantService;
import com.finace.common.exception.BizException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {
    final TenantMapper tenantMapper;

    /**
     * 创建租户
     *
     * @return
     */
    @Override
    public long add() {
        Tenant tenant = new Tenant();
        tenant.initDefault();
        if (tenantMapper.insert(tenant) == 0) {
            throw new BizException("创建租户失败");
        }
        return tenant.getId();
    }
}