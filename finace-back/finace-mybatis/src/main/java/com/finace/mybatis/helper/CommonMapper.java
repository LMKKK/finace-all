package com.finace.mybatis.helper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonMapper<T> {
    /**
     * 通过id删除数据
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据（所有字段）
     *
     * @param row
     * @return
     */
    int insert(T row);

    /**
     * 批量插入插入数据（所有字段）
     *
     * @param list
     * @return
     */
    int insertBatch(@Param("list") List<T> list);

    /**
     * 插入数据（不为null的字段）
     *
     * @param row
     * @return
     */
    int insertSelective(T row);

    /**
     * 批量插入（不为null的字段）
     *
     * @param list
     * @return
     */
    int insertBatchSelective(@Param("list") List<T> list);

    /**
     * 通过id查询记录
     *
     * @param id
     * @return
     */
    T selectByPrimaryKey(Long id);

    /**
     * 更新数据，通过id查询，更新不为null的字段
     *
     * @return
     */
    int updateByPrimaryKeySelective(T row);

    /**
     * 更新数据，通过id查询，更新所有字段
     *
     * @param row
     * @return
     */
    int updateByPrimaryKey(T row);

    /**
     * 查询数据集合，通过example构造查询条件
     *
     * @param example
     * @return
     */
    List<T> list(MyBatisWrapper<T> example);

    /**
     * 查询第一条数据，通过example构造查询条件
     *
     * @param example
     * @return
     */
    T topOne(MyBatisWrapper<T> example);

    /**
     * 统计记录条数，通过example构造查询条件
     *
     * @param example
     * @return
     */
    Integer count(MyBatisWrapper<T> example);

    /**
     * 更新记录，通过example设置更新的字段和更新条件
     *
     * @param example
     * @return
     */
    int updateField(@Param("example") MyBatisWrapper<T> example);

    /**
     * 批量更新，通过list设置更新的字段和更新条件
     *
     * @param list
     * @return
     */
    int updateFieldBatch(List<MyBatisWrapper<T>> list);

    /**
     * 查询一条数据，如返回多条则抛异常，通过example构造查询条件
     *
     * @param example
     * @return
     */
    T get(MyBatisWrapper<T> example);

    /**
     * 批量更新，通过id查询更新不为null的字段
     *
     * @param list
     * @return
     */
    int updateBatchSelective(@Param("list") List<T> list);
}