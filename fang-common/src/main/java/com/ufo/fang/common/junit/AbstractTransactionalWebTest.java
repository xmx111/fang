package com.ufo.fang.common.junit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/19
 */
@WebAppConfiguration
@TestExecutionListeners(
        value = {ServletTestExecutionListener.class, DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class},
        inheritListeners = false
)
@Transactional
public abstract class AbstractTransactionalWebTest extends AbstractTransactionalJUnit4SpringContextTests {
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mvc;

    public AbstractTransactionalWebTest() {
    }

    @Before
    public void _setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
}
