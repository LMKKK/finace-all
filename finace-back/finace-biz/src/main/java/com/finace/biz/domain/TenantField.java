package com.finace.biz.domain;

import com.finace.mybatis.helper.DbField;
import com.finace.mybatis.helper.FieldResult;

import java.util.Collections;

public class TenantField {
    public static DbField Id = new DbField("id", "id", "BIGINT", "java.lang.Long");

    public static DbField Name = new DbField("name", "name", "VARCHAR", "java.lang.String");

    public static DbField Disable = new DbField("disable", "disable", "BIT", "java.lang.Boolean");

    public static DbField CreateTime = new DbField("create_time", "createTime", "TIMESTAMP", "java.util.Date");

    public static DbField UpdateTime = new DbField("update_time", "updateTime", "TIMESTAMP", "java.util.Date");

    public static DbField AdminId = new DbField("admin_id", "adminId", "BIGINT", "java.lang.Long");

    public static DbField UpdateAdminId = new DbField("update_admin_id", "updateAdminId", "BIGINT", "java.lang.Long");

    public static DbField DelFlag = new DbField("del_flag", "delFlag", "BIT", "java.lang.Boolean");

    public static FieldResult setId(Long id) {
        return new FieldResult(Id, Collections.singletonList(id));
    }

    public static FieldResult setName(String name) {
        return new FieldResult(Name, Collections.singletonList(name));
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

    public static FieldResult setAdminId(Long adminId) {
        return new FieldResult(AdminId, Collections.singletonList(adminId));
    }

    public static FieldResult setUpdateAdminId(Long updateAdminId) {
        return new FieldResult(UpdateAdminId, Collections.singletonList(updateAdminId));
    }

    public static FieldResult setDelFlag(Boolean delFlag) {
        return new FieldResult(DelFlag, Collections.singletonList(delFlag));
    }
}