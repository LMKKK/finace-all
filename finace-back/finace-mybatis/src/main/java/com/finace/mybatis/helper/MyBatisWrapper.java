package com.finace.mybatis.helper;

import org.apache.logging.log4j.util.Strings;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class MyBatisWrapper<T> {
    public MyBatisWrapper() {
        this.oredCriteria = new ArrayList<>();
    }

    protected StringBuilder selectBuilder;
    protected StringBuilder whereBuilder;
    protected StringBuilder updateSql;
    protected StringBuilder orderByClause;
    protected StringBuilder groupBySql;
    protected Integer rows;
    protected Integer offset;
    protected Map<String, Object> updateRow;
    private Boolean countFlag = false;
    private Integer pageIndex;
    private Integer pageSize;

    //查询条件
    protected List<Criteria<T>> oredCriteria;

    public MyBatisWrapper<T> distinct(DbField... fields) {
        select(fields);
        selectBuilder.insert(0, "distinct ");
        return this;
    }

    /**
     * 查询指定的字段
     *
     * @param fields
     * @return
     */
    public MyBatisWrapper<T> select(DbField... fields) {
        if (fields == null || fields.length == 0) {
            return this;
        }
        if (selectBuilder == null) {
            selectBuilder = new StringBuilder();
        }
        for (DbField field : fields) {
            if (selectBuilder.length() > 0) {
                selectBuilder.append(",");
            }
            selectBuilder.append(field.getDbName());
        }
        return this;
    }

    public MyBatisWrapper<T> sum(DbField field) {
        sum(field, null);
        return this;
    }

    public MyBatisWrapper<T> sum(DbField... fields) {
        for (DbField field : fields) {
            sum(field, null);
        }
        return this;
    }

    public MyBatisWrapper<T> sum(DbField field, String asName) {
        if (selectBuilder == null) {
            selectBuilder = new StringBuilder();
        }

        if (selectBuilder.length() > 0) {
            selectBuilder.append(",");
        }
        selectBuilder.append("sum(");
        selectBuilder.append(field.getDbName());
        selectBuilder.append(")");
        if (Strings.isNotBlank(asName)) {
            selectBuilder.append(" as ");
            selectBuilder.append(asName);
        }
        return this;
    }

    public MyBatisWrapper<T> limit(int... limit) {
        this.offset = limit[0];
        if (limit.length > 1) {
            this.rows = limit[1];
        }
        return this;
    }

    /**
     * 设置要查询的分页信息
     *
     * @param pageIndex 页号
     * @param pageSize  页大小
     * @return
     */
    public MyBatisWrapper<T> page(int pageIndex, int pageSize) {
        return page(pageIndex, pageSize, true);
    }

    /**
     * 设置要查询的分页信息
     *
     * @param pageIndex   页号
     * @param pageSize    页大小
     * @param selectCount 是否查询记录条数
     * @return
     */
    public MyBatisWrapper<T> page(int pageIndex, int pageSize, boolean selectCount) {
        // 如果页码小于等于0，则返回第一页的数据
        if (pageIndex <= 0) {
            pageIndex = 1;
        }
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        // 计算偏移量
        int offset = (pageIndex - 1) * pageSize;
        this.countFlag = selectCount;
        return limit(offset, pageSize);
    }

    public MyBatisWrapper<T> orderByAsc(DbField... fields) {
        orderBy(fields);
        this.orderByClause.append(" asc");
        return this;
    }

    public MyBatisWrapper<T> orderByDesc(DbField... fields) {
        orderBy(fields);
        this.orderByClause.append(" desc");
        return this;
    }

    private MyBatisWrapper<T> orderBy(DbField... fields) {
        if (fields == null || fields.length == 0) {
            return this;
        }
        if (orderByClause == null) {
            orderByClause = new StringBuilder();
        }

        for (DbField field : fields) {
            if (orderByClause.length() > 0) {
                orderByClause.append(",");
            }
            orderByClause.append(field.getDbName());
        }
        return this;
    }

    public MyBatisWrapper<T> groupBy(DbField... fields) {
        if (fields == null || fields.length == 0) {
            return this;
        }
        if (groupBySql == null) {
            groupBySql = new StringBuilder();
        }

        for (DbField field : fields) {
            if (groupBySql.length() > 0) {
                groupBySql.append(",");
            }
            groupBySql.append(field.getDbName());
        }
        return this;
    }

    public MyBatisWrapper<T> update(DbField dbField, Object value) {
        return update(new FieldResult(dbField, Collections.singletonList(value)));
    }

    public MyBatisWrapper<T> update(FieldResult fieldResult) {
        if (this.updateSql == null) {
            this.updateSql = new StringBuilder();
        }
        this.updateSql
                .append(fieldResult.getField().getDbName())
                .append(" = #{example.updateRow.")
                .append(fieldResult.getField().getPropertyName())
                .append(", jdbcType=")
                .append(fieldResult.getField().getJdbcType())
                .append("},");
        if (this.updateRow == null) {
            this.updateRow = new HashMap<>();
        }
        this.updateRow.put(fieldResult.getField().getPropertyName(), fieldResult.getValue());
        return this;
    }

    public MyBatisWrapper<T> updateIncr(DbField dbField, Object value) {
        return updateIncr(new FieldResult(dbField, Collections.singletonList(value)));
    }

    public MyBatisWrapper<T> updateIncr(FieldResult fieldResult) {
        if (this.updateSql == null) {
            this.updateSql = new StringBuilder();
        }
        this.updateSql
                .append(fieldResult.getField().getDbName())
                .append(" = ")
                .append(fieldResult.getField().getDbName())
                .append(" + ")
                .append(" #{example.updateRow.")
                .append(fieldResult.getField().getPropertyName())
                .append(", jdbcType=")
                .append(fieldResult.getField().getJdbcType())
                .append("},");
        if (this.updateRow == null) {
            this.updateRow = new HashMap<>();
        }
        this.updateRow.put(fieldResult.getField().getPropertyName(), fieldResult.getValue());
        return this;
    }

    public MyBatisWrapper<T> updateDecr(DbField dbField, Object value) {
        return updateDecr(new FieldResult(dbField, Collections.singletonList(value)));
    }

    public MyBatisWrapper<T> updateDecr(FieldResult fieldResult) {
        if (this.updateSql == null) {
            this.updateSql = new StringBuilder();
        }
        this.updateSql
                .append(fieldResult.getField().getDbName())
                .append(" = ")
                .append(fieldResult.getField().getDbName())
                .append(" - ")
                .append(" #{example.updateRow.")
                .append(fieldResult.getField().getPropertyName())
                .append(", jdbcType=")
                .append(fieldResult.getField().getJdbcType())
                .append("},");
        if (this.updateRow == null) {
            this.updateRow = new HashMap<>();
        }
        this.updateRow.put(fieldResult.getField().getPropertyName(), fieldResult.getValue());
        return this;
    }

    /**
     * 联接字符串
     *
     * @param dbField
     * @param value
     * @return
     */
    public MyBatisWrapper<T> updateConcat(DbField dbField, Object value) {
        return updateConcat(new FieldResult(dbField, Collections.singletonList(value)));
    }

    /**
     * 联接字符串
     *
     * @param fieldResult
     * @return
     */
    public MyBatisWrapper<T> updateConcat(FieldResult fieldResult) {
        if (this.updateSql == null) {
            this.updateSql = new StringBuilder();
        }
        this.updateSql
                .append(fieldResult.getField().getDbName())
                .append(" = CONCAT(")
                .append(fieldResult.getField().getDbName())
                .append(" , ")
                .append(" #{example.updateRow.")
                .append(fieldResult.getField().getPropertyName())
                .append(", jdbcType=")
                .append(fieldResult.getField().getJdbcType())
                .append("}),");
        if (this.updateRow == null) {
            this.updateRow = new HashMap<>();
        }
        this.updateRow.put(fieldResult.getField().getPropertyName(), fieldResult.getValue());
        return this;
    }

    public MyBatisWrapper<T> selectCount(boolean countFlag) {
        this.countFlag = countFlag;
        return this;
    }

    public List<Criteria<T>> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria<T> criteria) {
        criteria.setAndOrOr(false);
        oredCriteria.add(criteria);
    }

    public Criteria<T> or() {
        Criteria<T> criteria = createCriteriaInternal();
        criteria.setAndOrOr(false);
        oredCriteria.add(criteria);
        return criteria;
    }

    public void and(Criteria<T> criteria) {
        criteria.setAndOrOr(true);
        oredCriteria.add(criteria);
    }

    public Criteria<T> and() {
        Criteria<T> criteria = createCriteriaInternal();
        criteria.setAndOrOr(true);
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建查询条件
     *
     * @return
     */
    public Criteria<T> whereBuilder() {
        Criteria<T> criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria<T> createCriteriaInternal() {
        Criteria<T> criteria = new Criteria<>();
        return criteria;
    }

    public void clear() {
        selectBuilder = null;
        whereBuilder = null;
        updateSql = null;
        if (!CollectionUtils.isEmpty(oredCriteria)) {
            oredCriteria.clear();
        }
    }

    public StringBuilder getSelectBuilder() {
        return selectBuilder;
    }

    public void setSelectBuilder(StringBuilder selectBuilder) {
        this.selectBuilder = selectBuilder;
    }

    public StringBuilder getWhereBuilder() {
        return whereBuilder;
    }

    public void setWhereBuilder(StringBuilder whereBuilder) {
        this.whereBuilder = whereBuilder;
    }

    public StringBuilder getUpdateSql() {
        return updateSql;
    }

    public void setUpdateSql(StringBuilder updateSql) {
        this.updateSql = updateSql;
    }

    public StringBuilder getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(StringBuilder orderByClause) {
        this.orderByClause = orderByClause;
    }

    public StringBuilder getGroupBySql() {
        return groupBySql;
    }

    public void setGroupBySql(StringBuilder groupBySql) {
        this.groupBySql = groupBySql;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Map<String, Object> getUpdateRow() {
        return updateRow;
    }

    public void setUpdateRow(Map<String, Object> updateRow) {
        this.updateRow = updateRow;
    }

    public void setOredCriteria(List<Criteria<T>> oredCriteria) {
        this.oredCriteria = oredCriteria;
    }

    public Boolean getCountFlag() {
        return countFlag;
    }

    public void setCountFlag(Boolean countFlag) {
        this.countFlag = countFlag;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 分页查询
     *
     * @param commonMapper
     * @return
     */
    public PageInfo<T> listPage(CommonMapper<T> commonMapper) {
        int count = 0;
        if (countFlag) {
            count = commonMapper.count(this);
        }
        return new PageInfo<>(this.pageIndex, this.pageSize,
                count,
                commonMapper.list(this));
    }
}
