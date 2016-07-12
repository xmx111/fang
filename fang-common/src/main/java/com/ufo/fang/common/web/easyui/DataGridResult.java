package com.ufo.fang.common.web.easyui;

import com.ufo.fang.common.mybatis.pagehelper.PageList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * easyUI datagrid数据结果集
 * 
 * @author hekang
 * @created 2016-01-12
 */
public class DataGridResult<T> {

	/**
	 * 数据的总数
	 */
	private long total;

	private Object model;

	private List<T> footer;

	/**
	 * 需要显示的数据
	 */
	private List<T> rows;//

	public DataGridResult() {
	}

	public DataGridResult(PageList<T> pageList) {
		if(pageList == null) {
			this.total = 0;
			this.rows = Collections.emptyList();
		} else {
			this.total = pageList.getTotal();
			this.rows = pageList.getList();
		}
	}

	public DataGridResult(long total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	/* 总记录数 */
	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return (rows != null ? rows : new ArrayList<T>());
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Object getModel() {
		return model == null ? 0 : model;
	}

	public void setModel(Object model) {
		this.model = model;
	}

	public void setFooter(List<T> footer) {
		this.footer = footer;
	}

	public List<T> getFooter() {
		return footer;
	}

	public void addFooter(T footer) {
		if (this.footer == null || this.footer.size() == 0)
			this.footer = new ArrayList<T>();
		this.footer.add(footer);
	}
}
