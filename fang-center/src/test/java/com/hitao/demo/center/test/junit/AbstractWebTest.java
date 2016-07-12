/** Copyright 2013-2023 嗨淘网. */
package com.ufo.fang.center.test.junit;

import com.ufo.fang.center.test.TestEnv;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;

/**
 * 
 * 
 * @author <a href="mailto:sunzhiqiang@hitao.com">孙智强</a>
 * @since 0.1.0
 */
@ContextHierarchy({
	@ContextConfiguration({"classpath:/spring/app.xml", "classpath:/junit-test.xml"}),
	@ContextConfiguration({"classpath:/spring/servlet-app.xml", "classpath:/junit-servlet.xml"})
})
public abstract class AbstractWebTest extends com.hitao.framework.junit.AbstractWebTest {

	@Autowired
	protected TestEnv testEnv;

	@Autowired
	protected MockHttpSession session;
	
	@Before
	@Override
	public void _setup() {
		super._setup();
		testEnv.setSession(session);
	}
}