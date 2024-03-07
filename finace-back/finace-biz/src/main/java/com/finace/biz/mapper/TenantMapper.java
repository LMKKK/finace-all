package com.finace.biz.mapper;

import com.bage.mybatis.help.CommonMapper;
import com.finace.biz.domain.Tenant;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TenantMapper extends CommonMapper<Tenant> {
}