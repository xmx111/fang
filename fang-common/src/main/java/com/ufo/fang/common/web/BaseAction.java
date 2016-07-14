package com.ufo.fang.common.web;

import com.ufo.fang.common.mybatis.pagehelper.PageList;
import com.ufo.fang.common.web.ajax.AjaxConstant;
import com.ufo.fang.common.web.ajax.AjaxResult;
import com.ufo.fang.common.web.converter.DatePropertyEdit;
import com.ufo.fang.common.web.easyui.DataGridResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;

/***
 * 控制器抽象类
 *
 * @author hekang
 * @created 2016/1/12
 */
public abstract class BaseAction {

    /***
     * ftl file path
     */
    private static final String VIEWPATH = "/view/";

    protected final Logger logger = LogManager.getLogger(this.getClass());

    /***
     * 获得session中的用户ID
     */
    public Long getUserID(HttpServletRequest request) {
        return Long.valueOf(SessionHelper.getUserId(request.getSession()));
    }

    /***
     * 获得session中的用户名称
     */
    public String getUserName(HttpServletRequest request) {
        return SessionHelper.getUserName(request.getSession());
    }

    protected <T> DataGridResult<T> buildDateGrid(PageList<T> pageList) {
        return new DataGridResult<T>(pageList);
    }

    /**
     * 后台AjaxResult格式的json数据返回 成功
     * @return
     */
    protected AjaxResult success() {
        return success(null);
    }

    /**
     * 后台AjaxResult格式的json数据返回 成功
     * @param obj
     * @return
     */
    protected AjaxResult success(Object obj) {
        AjaxResult result = new AjaxResult();
        result.setSucceed();
        result.setMessage(result.getResultMessage());
        result.put(AjaxConstant.DATA, obj);
        return result;
    }

    /**
     * 后台AjaxResult格式的json数据返回 成功
     * @param obj
     * @param msg
     * @return
     */
    protected AjaxResult success(Object obj, String msg) {
        AjaxResult result = new AjaxResult();
        result.setSucceed();
        result.setMessage(msg);
        result.put(AjaxConstant.DATA, obj);
        return result;
    }

    /**
     * 后台AjaxResult格式的json数据返回 失败
     * @return
     */
    protected AjaxResult failed() {
        return failed(null);
    }

    /**
     * 后台AjaxResult格式的json数据返回 失败
     * @param obj
     * @return
     */
    protected AjaxResult failed(Object obj) {
        AjaxResult result = new AjaxResult();
        result.setMessage(result.getResultMessage());
        result.put(AjaxConstant.DATA, obj);
        return result;
    }

    /**
     * 后台AjaxResult格式的json数据返回 失败
     * @param obj
     * @param msg
     * @return
     */
    protected AjaxResult failed(Object obj, String msg) {
        AjaxResult result = new AjaxResult();
        result.setMessage(msg);
        result.put(AjaxConstant.DATA, obj);
        return result;
    }

    /**
     * 将相对模块路径视图转化为相对项目路径视图
     * @param path
     * @return
     */
    protected String toView(String path) {
        String _path = VIEWPATH + path;
        if (logger.isDebugEnabled()) {
            logger.debug("jsp path is " + _path);
        }
        return _path;
    }

    /** 跳转到指定页 ,浏览器显示原地址
     * @param url
     * @return
     */
    protected String forward(String url) {
        if (logger.isDebugEnabled()) {
            logger.debug("forward url is " + url);
        }
        return "forward:" + url;
    }

    /**
     * 跳转到指定页 ,浏览器显示跳转后的地址
     * @param url
     * @return
     */
    protected String redirect(String url) {
        if (logger.isDebugEnabled()) {
            logger.debug("redirect url is " + url);
        }
        return "redirect:" + url;
    }

    /**
     * 数据绑定
     * @param binder
     */
    @InitBinder
    public void binder(WebDataBinder binder) {
        DatePropertyEdit datePropertyEditor = new DatePropertyEdit(java.util.Date.class);
        binder.registerCustomEditor(java.util.Date.class, datePropertyEditor);
    }


    @ExceptionHandler
    public String exp(HttpServletRequest request, Exception ex) {
        request.setAttribute("ex", ex);
        if (request.getRequestURI().indexOf(".htm") != -1)
            return "error";
        return null;
    }
}
