package com.finace.biz.mapper;

import com.bage.mybatis.help.CommonMapper;
import com.finace.biz.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends CommonMapper<Member> {
}