package com.ufo.fang.common.junit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public abstract class AbstractWebTest {
    protected final Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected ApiSignRequestPostProcessor apiSignRequestPostProcessor;

    protected MockMvc mvc;

    public AbstractWebTest() {
    }

    @Before
    public void _setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
}
