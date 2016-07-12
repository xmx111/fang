package com.ufo.fang.common.web;

import javax.servlet.http.HttpSession;

import static com.ufo.fang.common.web.SessionKeeper.ADMIN_ROLES;
import static com.ufo.fang.common.web.SessionKeeper.CAN_GRANT_PERMISSION;
import static com.ufo.fang.common.web.SessionKeeper.ID;
import static com.ufo.fang.common.web.SessionKeeper.IS_ADMIN;
import static com.ufo.fang.common.web.SessionKeeper.IS_SUPER_ADMIN;
import static com.ufo.fang.common.web.SessionKeeper.LOGIN_STATUS;
import static com.ufo.fang.common.web.SessionKeeper.NAME;
import static com.ufo.fang.common.web.SessionKeeper.NORMAL_ROLES;
import static com.ufo.fang.common.web.SessionKeeper.PERMISSION;
import static com.ufo.fang.common.web.SessionKeeper.USER_SOURCE_ID;
import static com.ufo.fang.common.web.SessionKeeper.USER_SOURCE_TYPE;
/**
 * Session 辅助类
 * 
 * @author zhangzhiwen.ht
 * @created 2011-12-21
 */
public class SessionHelper {
	/**
	 * 获取用户来源类型
	 * 
	 * @param session
	 * @return
	 */
	public static String getUserSourceType(HttpSession session) {
		return String.valueOf(session.getAttribute(USER_SOURCE_TYPE));
	}

	/**
	 * 获取用户来源ID 如果USER_SOURCE_TYPE是供应商，那么保存的是供应商id
	 * 
	 * @param session
	 * @return
	 */
	public static String getUserSourceId(HttpSession session) {
		return String.valueOf(session.getAttribute(USER_SOURCE_ID));
	}

	/**
	 * 获取用户Id
	 * 
	 * @param session
	 * @return
	 */
	public static String getUserId(HttpSession session) {
		return String.valueOf(session.getAttribute(ID));
	}

	/**
	 * 获取用户名称
	 * 
	 * @param session
	 * @return
	 */
	public static String getUserName(HttpSession session) {
		return String.valueOf(session.getAttribute(NAME));
	}

	/**
	 * 获取登录标识
	 * 
	 * @param session
	 * @return
	 */
	public static String getLoginStatus(HttpSession session) {
		return String.valueOf(session.getAttribute(LOGIN_STATUS));
	}

	/**
	 * 获取权限码
	 * 
	 * @param session
	 * @return
	 */
	public static String getUserPermission(HttpSession session) {
		return String.valueOf(session.getAttribute(PERMISSION));
	}
	
	/**
	 * 获取授权
	 * 
	 * @param session
	 * @return
	 */
	public static String getGrantPermission(HttpSession session) {
		return String.valueOf(session.getAttribute(CAN_GRANT_PERMISSION));
	}
	
	/**
	 * 获取是否超级管理员
	 * 
	 * @param session
	 * @return
	 */
	public static Boolean getIsSuperAdmin(HttpSession session) {
		return (Boolean) session.getAttribute(IS_SUPER_ADMIN);
	}
	
	/**
	 * 获取是否管理员
	 * 
	 * @param session
	 * @return
	 */
	public static Boolean getIsAdmin(HttpSession session) {
		return (Boolean) session.getAttribute(IS_ADMIN);
	}
	
	/**
	 * 获取管理员角色集
	 * 
	 * @param session
	 * @return
	 */
	public static String getAdminRoles(HttpSession session) {
		return (String) session.getAttribute(ADMIN_ROLES);
	}
	
	/**
	 * 获取普通角色集
	 * 
	 * @param session
	 * @return
	 */
	public static String getNormalRoles(HttpSession session) {
		return (String) session.getAttribute(NORMAL_ROLES);
	}
}
