/** Copyright 2013-2023 嗨淘网. */
package com.ufo.fang.center.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.PostConstruct;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * 测试环境服务，负责测试数据的准备
 * @author <a href="mailto:sunzhiqiang@hitao.com">孙智强</a>
 * @since 0.1.0
 */
public class TestEnv {
	protected final Logger logger = LogManager.getLogger(getClass());
	private MockHttpSession session;
	private boolean logined;
	
	public void setSession(MockHttpSession session) {
		this.session = session;
	}

	@PostConstruct
	public void init() {
		logger.info("测试环境初始化……");
	}
	
	
	public void login(MockMvc mvc) throws Exception {
		if (logined) return;
		
		String user = "admin", pwd = "admin123";
		if ("plat".equals(System.getProperty("spring.profiles.active"))) {
			user = "18711037449";
			pwd = "12345678";
		}
		
		mvc.perform(post("/login").session(session)
				.param("user", user).param("pwd", pwd))
				.andExpect(jsonPath("$.id").exists());
		logined = true;
	}
	
	public void logout(MockMvc mvc) throws Exception {
		logined = false;
		mvc.perform(get("/login/logout").session(session));
	}
}
