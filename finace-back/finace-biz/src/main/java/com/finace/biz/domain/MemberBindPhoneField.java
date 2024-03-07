package com.finace.biz.domain;

import com.finace.mybatis.helper.DbField;
import com.finace.mybatis.helper.FieldResult;

import java.util.Collections;

public class MemberBindPhoneField {
    public static DbField Id = new DbField("id", "id", "BIGINT", "java.lang.Long");

    public static DbField Phone = new DbField("phone", "phone", "VARCHAR", "java.lang.String");

    public static DbField MemberId = new DbField("member_id", "memberId", "BIGINT", "java.lang.Long");

    public static DbField Disable = new DbField("disable", "disable", "BIT", "java.lang.Boolean");

    public static DbField CreateTime = new DbField("create_time", "createTime", "TIMESTAMP", "java.util.Date");

    public static DbField UpdateTime = new DbField("update_time", "updateTime", "TIMESTAMP", "java.util.Date");

    public static DbField Password = new DbField("password", "password", "VARCHAR", "java.lang.String");

    public static FieldResult setId(Long id) {
        return new FieldResult(Id, Collections.singletonList(id));
    }

    public static FieldResult setPhone(String phone) {
        return new FieldResult(Phone, Collections.singletonList(phone));
    }

    public static FieldResult setMemberId(Long memberId) {
        return new FieldResult(MemberId, Collections.singletonList(memberId));
    }

    public static FieldResult setDisable(Boolean disable) {
        return new FieldResult(Disable, Collections.singletonList(disable));
    }

    public static FieldResult setCreateTime(java.util.Date createTime) {
        return new FieldResult(CreateTime, Collections.singletonList(createTime));
    }

    public static FieldResult setUpdateTime(java.util.Date updateTime) {
        return new FieldResult(UpdateTime, Collections.singletonList(updateTime));
    }

    public static FieldResult setPassword(String password) {
        return new FieldResult(Password, Collections.singletonList(password));
    }
}