package com.finace.biz.mapper;

import com.finace.biz.domain.Tenant;
import com.finace.mybatis.helper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TenantMapper extends CommonMapper<Tenant> {
}