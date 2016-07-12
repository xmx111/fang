package com.ufo.fang.common.mybatis.pagehelper;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * Describe
 *
 * @author hekang
 * @version $Id:$
 * @created 2016/1/12
 */
public class PageList<T> extends PageInfo {

    private static final long serialVersionUID = 3365169527951871812L;

    public static final int MINSIZE = 20;

    private T footer;

    public PageList(){
    }

    /**
     * 默认每页20
     *
     * @param list
     */
    public PageList(List<T> list){
        super(list, 20);
    }

    /**
     * 调用父类构造
     *
     * @param list          page结果
     * @param navigatePages 页码数量
     */
    public PageList(List<T> list, int navigatePages){
        super(list, navigatePages);
    }

    public T getFooter() {
        return footer;
    }

    public void setFooter(T footer) {
        this.footer = footer;
    }
}
