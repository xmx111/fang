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

	/**
	 * 房源类型
	 */
	KeyValue<Integer, String> HOUSE_STYLE_HOME = new KeyValue<Integer, String>(0, "住宅", 0);
	KeyValue<Integer, String> HOUSE_STYLE_VILLA = new KeyValue<Integer, String>(1, "别墅", 1);
	KeyValue<Integer, String> HOUSE_STYLE_SHOPS = new KeyValue<Integer, String>(2, "商铺", 2);
	KeyValue<Integer, String> HOUSE_STYLE_OFFICE = new KeyValue<Integer, String>(3, "写字楼", 3);
	KeyValueType<Integer, String> HOUSE_STYLE = new KeyValueType<Integer, String>("houseStyle", "房源类型", HOUSE_STYLE_HOME, HOUSE_STYLE_VILLA, HOUSE_STYLE_SHOPS, HOUSE_STYLE_OFFICE);

	/**
	 * 房源来源
	 */
	KeyValue<Integer, String> HOUSE_SOURCE_58 = new KeyValue<Integer, String>(0, "58同城", 0);
	KeyValue<Integer, String> HOUSE_SOURCE_GANJI = new KeyValue<Integer, String>(1, "赶集网", 1);
	KeyValue<Integer, String> HOUSE_SOURCE_ANJUKE = new KeyValue<Integer, String>(2, "安居客", 2);
	KeyValue<Integer, String> HOUSE_SOURCE_SINA = new KeyValue<Integer, String>(3, "新浪乐居", 3);
	KeyValue<Integer, String> HOUSE_SOURCE_JIAODIAN = new KeyValue<Integer, String>(4, "焦点网", 4);
	KeyValue<Integer, String> HOUSE_SOURCE_YIDENG = new KeyValue<Integer, String>(5, "易登网", 5);
	KeyValue<Integer, String> HOUSE_SOURCE_0731 = new KeyValue<Integer, String>(6, "0731房产网", 6);
	KeyValueType<Integer, String> HOUSE_SOURCE = new KeyValueType<Integer, String>("houseSource", "房源来源", HOUSE_SOURCE_58, HOUSE_SOURCE_GANJI, HOUSE_SOURCE_ANJUKE, HOUSE_SOURCE_SINA, HOUSE_SOURCE_JIAODIAN, HOUSE_SOURCE_YIDENG, HOUSE_SOURCE_0731);

	/**
	 * 户型
	 */
	KeyValue<Integer, String> HOUSE_TYPE_1 = new KeyValue<Integer, String>(0, "一居室", 0);
	KeyValue<Integer, String> HOUSE_TYPE_2 = new KeyValue<Integer, String>(1, "二居室", 1);
	KeyValue<Integer, String> HOUSE_TYPE_3 = new KeyValue<Integer, String>(2, "三居室", 2);
	KeyValue<Integer, String> HOUSE_TYPE_4 = new KeyValue<Integer, String>(3, "四居室", 3);
	KeyValue<Integer, String> HOUSE_TYPE_5 = new KeyValue<Integer, String>(4, "五居室", 4);
	KeyValue<Integer, String> HOUSE_TYPE_6 = new KeyValue<Integer, String>(5, "六居室", 5);
	KeyValue<Integer, String> HOUSE_TYPE_7 = new KeyValue<Integer, String>(6, "七居室", 6);
	KeyValueType<Integer, String> HOUSE_TYPE = new KeyValueType<Integer, String>("houseType", "户型", HOUSE_TYPE_1, HOUSE_TYPE_2, HOUSE_TYPE_3, HOUSE_TYPE_4, HOUSE_TYPE_5, HOUSE_TYPE_6, HOUSE_TYPE_7);
}
