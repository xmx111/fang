package com.ufo.fang.common.service;

import com.ufo.fang.common.exceptions.ServiceException;
import com.ufo.fang.common.mybatis.pagehelper.PageList;

import java.util.List;
import java.util.Map;

/***
 * 基础服务接口
 *
 * @author hekang
 * @created 2016/1/12
 */
public interface BaseService<T, ID> {

    int add(T model) throws ServiceException;

    int modify(T model) throws ServiceException;

    int delete(ID id) throws ServiceException;

    T queryById(ID id) throws ServiceException;

    PageList<T> queryForPage(Map<String, Object> parameterObject, Integer pageNum, Integer pageSize) throws ServiceException;

    PageList<T> queryForPageSum(Map<String, Object> parameterObject, Integer pageNum, Integer pageSize) throws ServiceException;

    int batchAdd(List<T> model) throws ServiceException;

    int batchDelete(List<ID> ids) throws ServiceException;

}
