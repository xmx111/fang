/** Copyright 2013-2023 嗨淘网. */
package com.ufo.fang.center.test.junit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * 除提供spring容器支持外，还对JUnit测试提供事务支持<br>
 * <ul>
 * 	<li>spring配置加载：@ContextConfiguration({"classpath*:spring/applicationContext*.xml"})</li>
 * </ul>
 * @see AbstractTest
 * @see AbstractTransactionalJUnit4SpringContextTests
 * @author 贺康
 * @since 0.1.0
 */
@ContextConfiguration({"classpath:/spring/app.xml", "classpath:/junit-test.xml"})
public abstract class AbstractTransactionalTest extends AbstractTransactionalJUnit4SpringContextTests {
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
