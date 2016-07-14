package com.ufo.fang.common.dao;

import com.ufo.fang.common.mybatis.pagehelper.PageList;

import java.util.List;
import java.util.Map;

/***
 * 数据访问接口
 *
 * @author hekang
 * @created 2016/1/11
 */
public interface BaseDAO<T, ID> {

    /**
     * 新增
     * @param model
     * @return
     */
    int insert(T model);

    /**
     * 修改
     * @param model
     * @return
     */
    int update(T model);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(ID id);

    /**
     * 根据id查询对象
     * @param id
     * @return
     */
    T selectById(ID id);

    /**
     * 查询所有对象列表
     * @return
     */
    List<T> selectAll();

    /**
     * 根据参数查询对象列表
     * @param parameters
     * @return
     */
    List<T> selectByParameters(Map<String, Object> parameters);

    /**
     * 分页查询
     * @param parameterObject
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageList<T> executeQueryForList(Map<String, Object> parameterObject, Integer pageNum, Integer pageSize);

    /**
     * 分页查询(有合计)
     * @param parameterObject
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageList<T> executeQueryForSumList(Map<String, Object> parameterObject, Integer pageNum, Integer pageSize);

    /**
     * 批量新增
     * @param model
     * @return
     */
    int batchInsert(List<T> model);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(List<ID> ids);
}
