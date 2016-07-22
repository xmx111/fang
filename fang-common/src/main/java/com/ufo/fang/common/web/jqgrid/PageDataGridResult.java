package com.ufo.fang.common.web.jqgrid;

import java.util.List;
import java.util.Map;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/21
 */
public class PageDataGridResult<T> {

    /**
     * 当前页数
     */
    private long page;

    /**
     * 总页数
     */
    private long total;

    /**
     * 数据的总数
     */
    private long records;

    /**
     *
     */
    private T userdata;

    /**
     * 需要显示的数据
     */
    private List<T> rows;

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public T getUserdata() {
        return userdata;
    }

    public void setUserdata(T userdata) {
        this.userdata = userdata;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
