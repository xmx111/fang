/** Copyright 2013-2023 嗨淘网. */
package com.ufo.fang.center.test.junit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * 带有spring容器环境的测试类<br>
 * bean注入，直接使用@Autowired注入
 * <ul>
 * 	<li>spring配置加载：@ContextConfiguration({"classpath*:spring/applicationContext*.xml"})</li>
 * </ul>
 * @author <a href="mailto:sunzhiqiang@hitao.com">孙智强</a>
 * @since 0.1.0
 */
@ContextConfiguration({"classpath:/spring/app.xml", "classpath:/junit-test.xml"})
public abstract class AbstractTest extends AbstractJUnit4SpringContextTests {
	protected final Logger logger = LogManager.getLogger(getClass());
	
	/**
	 * 根据类型获取bean
	 * @param clazz	bean类型
	 * @return bean
	 * @see ApplicationContext#getBean(Class)
	 */
	public <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
}

