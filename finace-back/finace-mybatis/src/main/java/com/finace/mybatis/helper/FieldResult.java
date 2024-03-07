package com.finace.mybatis.helper;

import java.util.List;

public class FieldResult {
    private DbField field;
    private Object value;
    private List<?> values;

    public FieldResult(DbField field, List<?> values) {
        this.field = field;
        this.values = values;
        if (values.size() == 1) {
            this.value = values.get(0);
        }
    }

    public DbField getField() {
        return field;
    }

    public void setField(DbField field) {
        this.field = field;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public List<?> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }
}