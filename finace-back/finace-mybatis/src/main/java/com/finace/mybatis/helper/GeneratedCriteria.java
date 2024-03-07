package com.finace.mybatis.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class GeneratedCriteria<T> {
    protected List<Criterion> criteria;

    protected GeneratedCriteria() {
        super();
        criteria = new ArrayList<>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
        return criteria;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    protected void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property, String jdbcType) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value, jdbcType));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property, String jdbcType) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value1, value2, jdbcType));
    }


    public Criteria<T> andIsNull(DbField field) {
        addCriterion(" and " + field.getDbName() + " is null");
        return (Criteria<T>) this;
    }

    public Criteria<T> andIsNotNull(DbField field) {
        addCriterion(" and " + field.getDbName() + " is not null");
        return (Criteria<T>) this;
    }

    public Criteria<T> andEq(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " =",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andEq(DbField dbField, Object value) {
        checkFieldValueType(dbField, value);

        addCriterion(" and " + dbField.getDbName() + " =",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andEq(DbField dbField1, DbField dbField2) {
        addCriterion(" and " + dbField1.getDbName() + " = " + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> andNE(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " <>",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andNE(DbField dbField, Object value) {
        checkFieldValueType(dbField, value);
        addCriterion(" and " + dbField.getDbName() + " <>",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andNE(DbField dbField1, DbField dbField2) {
        addCriterion(" and " + dbField1.getDbName() + " <>" + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> andGT(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " >",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andGT(DbField dbField, Object value) {
        checkFieldValueType(dbField, value);
        addCriterion(" and " + dbField.getDbName() + " >",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andGT(DbField dbField1, DbField dbField2) {
        addCriterion(" and " + dbField1.getDbName() + " >" + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> andGTE(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " >=",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andGTE(DbField dbField, Object value) {
        addCriterion(" and " + dbField.getDbName() + " >=",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andGTE(DbField dbField1, DbField dbField2) {
        addCriterion(" and " + dbField1.getDbName() + " >=" + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> andLT(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " <",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andLT(DbField dbField, Object value) {
        checkFieldValueType(dbField, value);
        addCriterion(" and " + dbField.getDbName() + " <",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andLT(DbField dbField1, DbField dbField2) {
        addCriterion(" and " + dbField1.getDbName() + " <" + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> andLTE(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " <=",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andLTE(DbField dbField, Object value) {
        checkFieldValueType(dbField, value);
        addCriterion(" and " + dbField.getDbName() + " <=",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andLTE(DbField dbField1, DbField dbField2) {
        addCriterion(" and " + dbField1.getDbName() + " <=" + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> andIn(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " in",
                fieldResult.getValues(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andIn(DbField dbField, Object value) {
        checkFieldListValueType(dbField, value);
        addCriterion(" and " + dbField.getDbName() + " in",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    /**
     * and 模糊查询
     *
     * @param fieldResult
     * @return
     */
    public Criteria<T> andLike(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " like",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    /**
     * and 模糊查询
     *
     * @param dbField
     * @param value
     * @return
     */
    public Criteria<T> andLike(DbField dbField, Object value) {
        checkFieldValueType(dbField, value);
        addCriterion(" and " + dbField.getDbName() + " like",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andNotLike(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " not like",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andNotLike(DbField dbField, Object value) {
        addCriterion(" and " + dbField.getDbName() + " not like",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andNotIn(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " not in",
                fieldResult.getValues(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andNotIn(DbField dbField, Object value) {
        checkFieldListValueType(dbField, value);
        addCriterion(" and " + dbField.getDbName() + " not in",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andBetween(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " between",
                fieldResult.getValues().get(0),
                fieldResult.getValues().get(1),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andBetween(DbField dbField, Object value1, Object value2) {
        checkFieldValueType(dbField, value1);
        checkFieldValueType(dbField, value2);
        addCriterion(" and " + dbField.getDbName() + " between",
                value1,
                value2,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andNotBetween(FieldResult fieldResult) {
        addCriterion(" and " + fieldResult.getField().getDbName() + " not between",
                fieldResult.getValues().get(0),
                fieldResult.getValues().get(1),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> andNotBetween(DbField dbField, Object value1, Object value2) {
        checkFieldValueType(dbField, value1);
        checkFieldValueType(dbField, value2);
        addCriterion(" and " + dbField.getDbName() + " not between",
                value1,
                value2,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orIsNull(DbField field) {
        addCriterion(" or " + field.getDbName() + " is null");
        return (Criteria<T>) this;
    }

    public Criteria<T> orIsNotNull(DbField field) {
        addCriterion(" or " + field.getDbName() + " is not null");
        return (Criteria<T>) this;
    }

    public Criteria<T> orEq(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " =",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orEq(DbField dbField, Object value) {
        addCriterion(" or " + dbField.getDbName() + " =",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orEq(DbField dbField1, DbField dbField2) {
        addCriterion(" or " + dbField1.getDbName() + " = " + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> orNE(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " <>",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orNE(DbField dbField, Object value) {
        addCriterion(" or " + dbField.getDbName() + " <>",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orNE(DbField dbField1, DbField dbField2) {
        addCriterion(" or " + dbField1.getDbName() + " <>" + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> orGT(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " >",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orGT(DbField dbField, Object value) {
        addCriterion(" or " + dbField.getDbName() + " >",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orGT(DbField dbField1, DbField dbField2) {
        addCriterion(" or " + dbField1.getDbName() + " >" + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> orGTE(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " >=",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orGTE(DbField dbField, Object value) {
        addCriterion(" or " + dbField.getDbName() + " >=",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orGTE(DbField dbField1, DbField dbField2) {
        addCriterion(" or " + dbField1.getDbName() + " >=" + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> orLT(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " <",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orLT(DbField dbField, Object value) {
        addCriterion(" or " + dbField.getDbName() + " <",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orLT(DbField dbField1, DbField dbField2) {
        addCriterion(" or " + dbField1.getDbName() + " <" + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> orLTE(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " <=",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orLTE(DbField dbField, Object value) {
        addCriterion(" or " + dbField.getDbName() + " <=",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orLTE(DbField dbField1, DbField dbField2) {
        addCriterion(" or " + dbField1.getDbName() + " <=" + dbField2.getDbName());
        return (Criteria<T>) this;
    }

    public Criteria<T> orIn(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " in",
                fieldResult.getValues(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orIn(DbField dbField, Object value) {
        addCriterion(" or " + dbField.getDbName() + " in",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orNotIn(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " not in",
                fieldResult.getValues(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orNotIn(DbField dbField, Object value) {
        addCriterion(" or " + dbField.getDbName() + " not in",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orBetween(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " between",
                fieldResult.getValues().get(0), fieldResult.getValues().get(1),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orBetween(DbField dbField, Object value1, Object value2) {
        addCriterion(" or " + dbField.getDbName() + " between",
                value1, value2,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orNotBetween(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " not between",
                fieldResult.getValues().get(0),
                fieldResult.getValues().get(1),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orNotBetween(DbField dbField, Object value1, Object value2) {
        addCriterion(" or " + dbField.getDbName() + " not between",
                value1,
                value2,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orLike(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " like",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orLike(DbField dbField, Object value) {
        addCriterion(" or " + dbField.getDbName() + " like",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orNotLike(FieldResult fieldResult) {
        addCriterion(" or " + fieldResult.getField().getDbName() + " not like",
                fieldResult.getValue(),
                fieldResult.getField().getPropertyName(),
                fieldResult.getField().getJdbcType());
        return (Criteria<T>) this;
    }

    public Criteria<T> orNotLike(DbField dbField, Object value) {
        addCriterion(" or " + dbField.getDbName() + " not like",
                value,
                dbField.getPropertyName(),
                dbField.getJdbcType());
        return (Criteria<T>) this;
    }

    /**
     * 字段值数据类型检测
     *
     * @param dbField
     * @param value
     */
    private void checkFieldValueType(DbField dbField, Object value) {
        if (!value.getClass().getTypeName().equals(dbField.getJavaType())) {
            throw new RuntimeException(("字段：" + dbField.getPropertyName() + "，类型应该为：" + dbField.getJavaType() + "，而不是：" + value.getClass().getTypeName()));
        }
    }

    /**
     * 字段值数据类型检测
     *
     * @param dbField
     * @param value
     */
    private void checkFieldListValueType(DbField dbField, Object value) {
        // 判断obj是否为集合或数组类型
        if (value instanceof Collection || value instanceof Object[]) {
            // 判断集合或数组是否为null
            if (value instanceof Collection) {
                Collection<?> collection = (Collection<?>) value;
                // 遍历集合中的元素，判断是否为Integer类型
                for (Object element : collection) {
                    if (!element.getClass().getTypeName().equals(dbField.getJavaType())) {
                        throw new RuntimeException(("字段：" + dbField.getPropertyName() + "，类型应该为：" + dbField.getJavaType() + "，而不是：" + value.getClass().getTypeName()));
                    }
                }
            }
            if (value instanceof Object[]) {
                Object[] array = (Object[]) value;
                // 遍历数组中的元素，判断是否为Integer类型
                for (Object element : array) {
                    if (!element.getClass().getTypeName().equals(dbField.getJavaType())) {
                        throw new RuntimeException(("字段：" + dbField.getPropertyName() + "，类型应该为：" + dbField.getJavaType() + "，而不是：" + value.getClass().getTypeName()));
                    }
                }
            }
        }
    }
}
