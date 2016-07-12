package com.ufo.fang.common.web;

import com.ufo.fang.common.mybatis.pagehelper.PageList;
import com.ufo.fang.common.service.BaseService;
import com.ufo.fang.common.web.easyui.DataGridResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/***
 * 控制器抽象类
 *
 * @author hekang
 * @created 2016/1/12
 */
public abstract class BaseTemplateAction<T, ID> extends BaseAction {

    /***
     * ftl file path
     */
    private static final String VIEWPATH = "/view/";

    protected final Logger logger = LogManager.getLogger(this.getClass());

    /** 子类指定泛型对应的实体Service接口对象 */
    abstract protected BaseService<T, ID> getService();

    /**
     * 新增
     * @param t
     * @return
     */
    protected Object add(T t){
        getService().add(t);
        return success(true);
    }

    /**
     * 修改
     * @param t
     * @return
     */
    protected Object modify(T t){
        getService().modify(t);
        return success(true);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    protected Object delete(ID id){
        getService().delete(id);
        return success(true);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    protected Object delete(List<ID> ids){
        Map<ID, String> errorMessageMap = new LinkedHashMap();
        //对于批量删除,循环每个对象调用Service接口删除
        //这样可以方便某些对象删除失败不影响其他对象删除
        //如果业务逻辑需要确保批量对象删除在同一个事务则请子类覆写调用Service的批量删除接口
        for (ID id : ids) {
            try {
                getService().delete(id);
            } catch (Exception e) {
                logger.warn("删除失败", e);
                errorMessageMap.put(id, e.getMessage());
            }
        }
        int rejectSize = errorMessageMap.size();
        if (rejectSize == 0) {
            return this.success(true, "成功删除所有选取记录:" + ids.size() + "条");
        } else {
            if (rejectSize == ids.size()) {
                return this.failed(false, "所有选取记录删除操作失败:" + errorMessageMap);
            } else {
                return this.failed(false, "删除操作已处理. 成功:" + (ids.size() - rejectSize) + "条"
                        + ",失败:" + rejectSize + "条" + errorMessageMap);
            }
        }
    }

    /**
     * 转为DataGridResult对象
     * @param pageList
     * @return
     */
    protected DataGridResult gridResult(PageList<T> pageList){
        DataGridResult result = null;
        if (pageList.getTotal() != 0){
            result = new DataGridResult(pageList.getTotal(), pageList.getList());
            result.setTotal(pageList.getTotal());
            result.setRows(pageList.getList());
            if (pageList.getFooter() == null)
                result.setFooter(new ArrayList<>());
            else
                result.addFooter(pageList.getFooter());
        }
        return result;
    }
}
