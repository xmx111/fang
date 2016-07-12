package com.ufo.fang.common.dao.mapper;

import java.util.List;
import java.util.Map;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/1/17
 */
public interface BaseMapper<T, ID> {

    int deleteByPrimaryKey(ID id);

    int insert(T record);

    T selectByPrimaryKey(ID id);

    List<T> selectAll();

    int updateByPrimaryKey(T record);

    List<T> selectByParameters(Map<String, Object> parameters);

    int batchInsert(List<T> recordList);

    int batchDelete(List<ID> ids);
}
