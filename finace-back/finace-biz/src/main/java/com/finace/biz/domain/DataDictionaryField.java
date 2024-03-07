package com.finace.biz.domain;

import com.finace.mybatis.helper.DbField;
import com.finace.mybatis.helper.FieldResult;

import java.util.Collections;

public class DataDictionaryField {
    public static DbField Id = new DbField("id", "id", "BIGINT", "java.lang.Long");

    public static DbField DataCodeCate = new DbField("data_code_cate", "dataCodeCate", "VARCHAR", "java.lang.String");

    public static DbField DataCode = new DbField("data_code", "dataCode", "VARCHAR", "java.lang.String");

    public static DbField DataValue = new DbField("data_value", "dataValue", "VARCHAR", "java.lang.String");

    public static DbField DataSort = new DbField("data_sort", "dataSort", "INTEGER", "java.lang.Integer");

    public static DbField Disable = new DbField("disable", "disable", "BIT", "java.lang.Boolean");

    public static DbField CreateTime = new DbField("create_time", "createTime", "TIMESTAMP", "java.util.Date");

    public static DbField UpdateTime = new DbField("update_time", "updateTime", "TIMESTAMP", "java.util.Date");

    public static FieldResult setId(Long id) {
        return new FieldResult(Id, Collections.singletonList(id));
    }

    public static FieldResult setDataCodeCate(String dataCodeCate) {
        return new FieldResult(DataCodeCate, Collections.singletonList(dataCodeCate));
    }

    public static FieldResult setDataCode(String dataCode) {
        return new FieldResult(DataCode, Collections.singletonList(dataCode));
    }

    public static FieldResult setDataValue(String dataValue) {
        return new FieldResult(DataValue, Collections.singletonList(dataValue));
    }

    public static FieldResult setDataSort(Integer dataSort) {
        return new FieldResult(DataSort, Collections.singletonList(dataSort));
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
}