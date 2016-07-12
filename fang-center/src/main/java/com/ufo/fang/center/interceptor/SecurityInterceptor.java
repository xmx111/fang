package com.ufo.fang.center.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆验证拦截器
 *
 * @author hekang
 * @created 2016/1/15
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

	protected final Logger logger = LogManager.getLogger(getClass());
	private static Map<String, Object> json = new HashMap<>();

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		// TODO 用户验证
		return true;
	}
	
}
