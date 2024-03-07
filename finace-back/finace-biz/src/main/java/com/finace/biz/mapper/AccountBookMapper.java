package com.finace.biz.mapper;

import com.finace.biz.domain.AccountBook;
import com.finace.mybatis.helper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountBookMapper extends CommonMapper<AccountBook> {
}