package com.ufo.fang.center.constants;

/**
 * 通用字典
 * @author hekang@hitao.com
 * @created 2016年2月22日 下午2:29:35
 */
public interface CommonDic {

	/**
	 * 是否定义
	 */
	KeyValue<Boolean, String> BOOLEAN_TRUE = new KeyValue<Boolean, String>(Boolean.TRUE, "是", 0);
	KeyValue<Boolean, String> BOOLEAN_FALSE = new KeyValue<Boolean, String>(Boolean.FALSE, "否", 1);
	KeyValueType<Boolean, String> IS_BOOLEAN = new KeyValueType<Boolean, String>("isBoolean", "是否", BOOLEAN_TRUE, BOOLEAN_FALSE);

	/**
	 * 状态定义
	 */
	KeyValue<Integer, String> STATUS_DISABLE = new KeyValue<Integer, String>(2, "停用", 0);
	KeyValue<Integer, String> STATUS_ENABLE = new KeyValue<Integer, String>(1, "启用", 2);
	KeyValue<Integer, String> STATUS_SAVE = new KeyValue<Integer, String>(0, "存盘", 1);
	KeyValueType<Integer, String> STATUS = new KeyValueType<Integer, String>("status", "状态", STATUS_DISABLE, STATUS_ENABLE, STATUS_SAVE);

	/**
	 * 状态定义
	 */
	KeyValue<Integer, String> LOCK_STATUS_YES = new KeyValue<Integer, String>(1, "已锁定", 0);
	KeyValue<Integer, String> LOCK_STATUS_NO = new KeyValue<Integer, String>(0, "未锁定", 1);
	KeyValueType<Integer, String> LOCK_STATUS = new KeyValueType<Integer, String>("lockStatus", "锁定状态", LOCK_STATUS_YES, LOCK_STATUS_NO);
	
	/**
	 * 性别
	 */
	KeyValue<Integer, String> SEX_MAN = new KeyValue<Integer, String>(0, "男", 1);
	KeyValue<Integer, String> SEX_WOMAN = new KeyValue<Integer, String>(1, "女", 0);
	KeyValueType<Integer, String> SEX = new KeyValueType<Integer, String>("sex", "性别", SEX_MAN, SEX_WOMAN);
	
	
}
