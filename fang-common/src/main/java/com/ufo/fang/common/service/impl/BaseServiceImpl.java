package com.ufo.fang.common.service.impl;

import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.mybatis.pagehelper.PageList;
import com.ufo.fang.common.service.BaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

/***
 * 基础服务实现类
 *
 * @author hekang
 * @created 2016/1/12
 */
public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    protected final Logger logger = LogManager.getLogger(this.getClass());

    /** 子类设置具体的DAO对象实例 */
    abstract protected BaseDAO<T, ID> getDAO();

    @Override
    public int add(T model) {
        return getDAO().insert(model);
    }

    @Override
    public int modify(T model) {
        return getDAO().update(model);
    }

    @Override
    public int delete(ID id) {
        return getDAO().deleteById(id);
    }

    @Override
    public T queryById(ID id) {
        return getDAO().selectById(id);
    }

    @Override
    public PageList<T> queryForPage(Map<String, Object> parameterObject, Integer pageNum, Integer pageSize) {
        return getDAO().executeQueryForList(parameterObject, pageNum, pageSize);
    }

    @Override
    public int batchAdd(List<T> model) {
        return getDAO().batchInsert(model);
    }

    @Override
    public int batchDelete(List<ID> ids) {
        return getDAO().batchDelete(ids);
    }
}
