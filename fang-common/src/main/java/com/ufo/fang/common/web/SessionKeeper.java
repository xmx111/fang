package com.ufo.fang.common.web;

/***
 * Session 中的常量定义
 *
 * @author hekang
 * @created 2016/1/12
 */
public interface SessionKeeper {

	/********************************************************************
	 * Session key 定义
	 ********************************************************************/

	/**
	 * 用户ID
	 */
	String ID = "_id_";

	/**
	 * 用户姓名
	 */
	String NAME = "_na_";

	/**
	 * 登录状态
	 */
	String LOGIN_STATUS = "loginStatus";

	/**
	 * 用户权限 (存放在cookie中，用户关掉浏览器后或者session过期后，该cookie应该失效)
	 */
	String PERMISSION = "_rep_";

	/**
	 * 用户权限 (存放在cookie中，用户关掉浏览器后或者session过期后，该cookie应该失效)
	 */
	String CAN_GRANT_PERMISSION = "_grant_";
	
	/**
	 * 超级管理员标记
	 */
	String IS_SUPER_ADMIN = "_super_";
	
	/**
	 * 管理员标记
	 */
	String IS_ADMIN = "_admin_";
	
	/**
	 * 普通角色标记
	 */
	String NORMAL_ROLES = "_normalroles_";
	
	/**
	 * 管理员角色标记
	 */
	String ADMIN_ROLES = "_adminroles_";
	
	/**
	 * 验证码
	 */
	String CHECK_CODE = "checkCode";

	/**
	 * 菜单ID
	 */
	String MENU_IDS = "menuIds";

	/**
	 * 登录用户来源类型:1:内部用户； 2：供应商
	 */
	String USER_SOURCE_TYPE = "stype";

	/**
	 * 来源Id，如果用户类型来源为供应商，保存供应商id
	 */
	String USER_SOURCE_ID = "sid";

}
