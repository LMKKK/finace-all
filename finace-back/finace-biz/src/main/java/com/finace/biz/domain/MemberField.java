package com.finace.biz.domain;

import com.finace.mybatis.helper.DbField;
import com.finace.mybatis.helper.FieldResult;

import java.util.Collections;

public class MemberField {
    public static DbField Id = new DbField("id", "id", "BIGINT", "java.lang.Long");

    public static DbField NickName = new DbField("nick_name", "nickName", "VARCHAR", "java.lang.String");

    public static DbField Disable = new DbField("disable", "disable", "BIT", "java.lang.Boolean");

    public static DbField CreateTime = new DbField("create_time", "createTime", "TIMESTAMP", "java.util.Date");

    public static DbField UpdateTime = new DbField("update_time", "updateTime", "TIMESTAMP", "java.util.Date");

    public static DbField Name = new DbField("name", "name", "VARCHAR", "java.lang.String");

    public static DbField AvatarUrl = new DbField("avatar_url", "avatarUrl", "VARCHAR", "java.lang.String");

    public static DbField TenantId = new DbField("tenant_id", "tenantId", "BIGINT", "java.lang.Long");

    public static DbField Email = new DbField("email", "email", "VARCHAR", "java.lang.String");

    public static DbField SysRoleIds = new DbField("sys_role_ids", "sysRoleIds", "LONGVARCHAR", "java.lang.String");

    public static FieldResult setId(Long id) {
        return new FieldResult(Id, Collections.singletonList(id));
    }

    public static FieldResult setNickName(String nickName) {
        return new FieldResult(NickName, Collections.singletonList(nickName));
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

    public static FieldResult setName(String name) {
        return new FieldResult(Name, Collections.singletonList(name));
    }

    public static FieldResult setAvatarUrl(String avatarUrl) {
        return new FieldResult(AvatarUrl, Collections.singletonList(avatarUrl));
    }

    public static FieldResult setTenantId(Long tenantId) {
        return new FieldResult(TenantId, Collections.singletonList(tenantId));
    }

    public static FieldResult setEmail(String email) {
        return new FieldResult(Email, Collections.singletonList(email));
    }

    public static FieldResult setSysRoleIds(String sysRoleIds) {
        return new FieldResult(SysRoleIds, Collections.singletonList(sysRoleIds));
    }
}