package com.ufo.fang.common.service.impl;

import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.exceptions.ServiceException;
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
    public int add(T model) throws ServiceException {
        try {
            return getDAO().insert(model);
        } catch (Throwable e){
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int modify(T model) throws ServiceException {
        try {
            return getDAO().update(model);
        } catch (Throwable e){
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int delete(ID id) throws ServiceException {
        try {
            return getDAO().deleteById(id);
        } catch (Throwable e){
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public T queryById(ID id) throws ServiceException {
        try {
            return getDAO().selectById(id);
        } catch (Throwable e){
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public PageList<T> queryForPage(Map<String, Object> parameterObject, Integer pageNum, Integer pageSize) throws ServiceException {
        try {
            return getDAO().executeQueryForList(parameterObject, pageNum, pageSize);
        } catch (Throwable e){
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public PageList<T> queryForPageSum(Map<String, Object> parameterObject, Integer pageNum, Integer pageSize) throws ServiceException {
        try {
            return getDAO().executeQueryForSumList(parameterObject, pageNum, pageSize);
        } catch (Throwable e){
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int batchAdd(List<T> model) throws ServiceException {
        try {
            return getDAO().batchInsert(model);
        } catch (Throwable e){
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public int batchDelete(List<ID> ids) throws ServiceException {
        try {
            return getDAO().batchDelete(ids);
        } catch (Throwable e){
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
