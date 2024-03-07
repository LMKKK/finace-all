package com.finace.biz.domain;

import com.finace.mybatis.helper.DbField;
import com.finace.mybatis.helper.FieldResult;

import java.util.Collections;

public class SysConfigField {
    public static DbField Id = new DbField("id", "id", "INTEGER", "java.lang.Integer");

    public static DbField ConfigName = new DbField("config_name", "configName", "VARCHAR", "java.lang.String");

    public static DbField Type = new DbField("type", "type", "VARCHAR", "java.lang.String");

    public static DbField ConfigKey = new DbField("config_key", "configKey", "VARCHAR", "java.lang.String");

    public static DbField ConfigValue = new DbField("config_value", "configValue", "VARCHAR", "java.lang.String");

    public static DbField CreateTime = new DbField("create_time", "createTime", "TIMESTAMP", "java.util.Date");

    public static DbField UpdateTime = new DbField("update_time", "updateTime", "TIMESTAMP", "java.util.Date");

    public static DbField MemberId = new DbField("member_id", "memberId", "BIGINT", "java.lang.Long");

    public static DbField UpdateMemberId = new DbField("update_member_id", "updateMemberId", "BIGINT", "java.lang.Long");

    public static DbField DelFlag = new DbField("del_flag", "delFlag", "BIT", "java.lang.Boolean");

    public static DbField Disable = new DbField("disable", "disable", "BIT", "java.lang.Boolean");

    public static FieldResult setId(Integer id) {
        return new FieldResult(Id, Collections.singletonList(id));
    }

    public static FieldResult setConfigName(String configName) {
        return new FieldResult(ConfigName, Collections.singletonList(configName));
    }

    public static FieldResult setType(String type) {
        return new FieldResult(Type, Collections.singletonList(type));
    }

    public static FieldResult setConfigKey(String configKey) {
        return new FieldResult(ConfigKey, Collections.singletonList(configKey));
    }

    public static FieldResult setConfigValue(String configValue) {
        return new FieldResult(ConfigValue, Collections.singletonList(configValue));
    }

    public static FieldResult setCreateTime(java.util.Date createTime) {
        return new FieldResult(CreateTime, Collections.singletonList(createTime));
    }

    public static FieldResult setUpdateTime(java.util.Date updateTime) {
        return new FieldResult(UpdateTime, Collections.singletonList(updateTime));
    }

    public static FieldResult setMemberId(Long memberId) {
        return new FieldResult(MemberId, Collections.singletonList(memberId));
    }

    public static FieldResult setUpdateMemberId(Long updateMemberId) {
        return new FieldResult(UpdateMemberId, Collections.singletonList(updateMemberId));
    }

    public static FieldResult setDelFlag(Boolean delFlag) {
        return new FieldResult(DelFlag, Collections.singletonList(delFlag));
    }

    public static FieldResult setDisable(Boolean disable) {
        return new FieldResult(Disable, Collections.singletonList(disable));
    }
}