package com.finace.biz.mapper;

import com.finace.biz.domain.Member;
import com.finace.mybatis.helper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends CommonMapper<Member> {
}