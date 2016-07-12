package com.ufo.fang.common.dao.impl;

import com.github.pagehelper.PageHelper;
import com.ufo.fang.common.dao.BaseDAO;
import com.ufo.fang.common.dao.mapper.BaseMapper;
import com.ufo.fang.common.mybatis.pagehelper.PageList;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/***
 * 数据访问抽象类
 *
 * @author hekang
 * @created 2016/1/11
 */
public abstract class BaseDAOImpl<T, ID> implements BaseDAO<T, ID> {

//    @Resource
//    private SqlSession sqlSession;

    protected final Logger logger = LogManager.getLogger(this.getClass());

    /** 子类设置具体的DAO对象实例 */
    abstract protected BaseMapper<T, ID> getMapper();

    @Override
    public int insert(T model) {
        return getMapper().insert(model);
    }

    @Override
    public int update(T model) {
        return getMapper().updateByPrimaryKey(model);
    }

    @Override
    public int deleteById(ID id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public T selectById(ID id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    public List<T> selectByParameters(Map<String, Object> parameters) {
        return getMapper().selectByParameters(parameters);
    }

    @Override
    public int batchInsert(List<T> modelList) {
        return getMapper().batchInsert(modelList);
    }

    @Override
    public int batchDelete(List<ID> ids) {
        return getMapper().batchDelete(ids);
    }

    /**
     * 带参数的分页查询
     * @param parameterObject
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageList<T> executeQueryForList(Map<String, Object> parameterObject, Integer pageNum, Integer pageSize) {
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = PageList.MINSIZE;
        // 分页设置
        PageHelper.startPage(pageNum, pageSize);
        // 只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select方法）方法会被分页
        List<T> rows = selectByParameters(parameterObject);
        // 分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>，或者使用PageInfo类
        PageList pageList = new PageList(rows);
        return pageList;
    }

    /**
     * 带参数的合计分页查询，需要覆盖querySum方法
     * @param parameterObject
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageList<T> executeQueryForSumList(Map<String, Object> parameterObject, Integer pageNum, Integer pageSize) {
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = PageList.MINSIZE;
        // 分页设置
        PageHelper.startPage(pageNum, pageSize);
        // 只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select方法）方法会被分页
        List<T> rows = selectByParameters(parameterObject);
        // 分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>，或者使用PageInfo类
        PageList pageList = new PageList(rows, pageSize);
        T sumRows = querySum(parameterObject, pageNum, pageSize);
        pageList.setFooter(sumRows);
        return pageList;
    }

    /**
     * 查询合计记录
     * @param parameterObject
     * @param pageNum
     * @param pageSize
     * @return
     */
    protected T querySum(Map<String, Object> parameterObject, int pageNum, int pageSize){
        return null;
    }
}
