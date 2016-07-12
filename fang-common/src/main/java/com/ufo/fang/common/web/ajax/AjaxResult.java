package com.ufo.fang.common.web.ajax;

import java.util.HashMap;
import java.util.Map;

/**
 * AJAX 返回结果
 * 
 * @author jijingbang.ht
 * @created 2011-6-20 下午11:42:41
 * @version $Id: AjaxResult.java 7077 2012-02-26 11:15:29Z qingming $
 */
public class AjaxResult {
	public static final String SUCCEED = "succeed";

	public static final String FAILED = "failed";

	private String status;

	private String message;

	private Map<Object, Object> data = new HashMap<Object, Object>();

	public AjaxResult() {
		this.status = FAILED;
	}

	public void setSucceed(boolean succees) {
		if (succees) {
			this.status = SUCCEED;
		} else {
			this.status = FAILED;
		}
	}

	/**
	 * 设置为成功
	 * 
	 * @author jijingbang.ht
	 */
	public void setSucceed() {
		setSucceed(true);
	}

	/**
	 * 设置为失败
	 * 
	 * @author jijingbang.ht
	 */
	public void setFailed() {
		setSucceed(false);
	}

	public String getStatus() {
		return this.status;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * 设置AJAX传送的消息
	 * 
	 * @param message
	 *            ajax传送的消息
	 * @author jijingbang.ht
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 设置失败消息
	 * 
	 * @param message
	 */
	public void setFailedMessage(String message) {
		this.status = FAILED;
		this.message = message;
	}

	/**
	 * 设置成功的消息
	 * 
	 * @param message
	 */
	public void setSucceedMessage(String message) {
		this.status = SUCCEED;
		this.message = message;
	}
	public Map<Object, Object> getData() {
		return data;
	}

	/**
	 * 添加一个ajax要返回的数据
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @author jijingbang.ht
	 */
	public void put(Object key, Object value) {
		this.data.put(key, value);
	}
	
	/**
	 * 结果是否成功
	 * @return
	 */
	public boolean isSucceed(){
		return SUCCEED.equals(status);
	}

	/**
	 * 得到结果信息
	 *
	 * @return 返回结果信息
	 * @author jijingbang.ht
	 */
	public String getResultMessage() {
		if (null != message) {
			return message;
		} else {
			if (isSucceed()) {
				return "操作成功";
			} else {
				return "操作失败";
			}
		}
	}
}
