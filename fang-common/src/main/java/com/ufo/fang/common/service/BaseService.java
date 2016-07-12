package com.ufo.fang.common.service;

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

    int add(T model);

    int modify(T model);

    int delete(ID id);

    T queryById(ID id);

    PageList<T> queryForPage(Map<String, Object> parameterObject, Integer pageNum, Integer pageSize);

    int batchAdd(List<T> model);

    int batchDelete(List<ID> ids);

}
