package com.ufo.fang.common.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ufo.fang.common.mybatis.pagehelper.PageList;

import java.util.List;
import java.util.Map;

/**
 * 封装mybatis的PageHelper
 * @author zhangzhiwen@hitao.com
 * @created 2016年2月26日 下午5:06:08
 */
public class PageUtils {

    public static Integer MINSIZE = 20;

    public static String COUNTNAME = "totalNum";
	
	public static Page startPage(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
        	pageNum = 1;
        }
        if (pageSize == null) {
        	pageSize = MINSIZE;
        }
        return PageHelper.startPage(pageNum, pageSize);
	}

    public static Page startPageNotCount(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = MINSIZE;
        }
        return PageHelper.startPage(pageNum, pageSize, false);
    }

    public static <T> PageList getPageList(List<T> rows, Map<Object, Object> sumMap){
        PageList pageList = new PageList(rows);
        pageList.setTotal((Long)sumMap.get(COUNTNAME));
        if (rows.size() > 0) {
            pageList.setFooter(InvokeUtils.getInvokeMapToBean(rows.get(0).getClass(), sumMap));
        }
        return pageList;
    }
}
