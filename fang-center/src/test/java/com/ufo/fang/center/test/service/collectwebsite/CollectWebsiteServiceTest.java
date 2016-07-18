package com.ufo.fang.center.test.service.collectWebsite;

import com.ufo.fang.center.dao.collectWebsite.CollectWebsiteDAO;
import com.ufo.fang.center.test.junit.AbstractTest;
import com.ufo.fang.center.model.CollectWebsite;
import com.ufo.fang.common.mybatis.pagehelper.PageList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * CollectWebsiteService Tester.
 *
 * @author <Authors name>
 * @since <pre>2016-07-18</pre>
 * @version 1.0
 */
public class CollectWebsiteServiceTest extends AbstractTest {

    @Autowired
    CollectWebsiteDAO collectWebsiteDAO;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testAdd(){
        // TODO: Test goes here...
    }

    @Test
    public void testModify(){
        // TODO: Test goes here...
    }

    @Test
    public void testDelete(){
        // TODO: Test goes here...
    }

    @Test
    public void testQueryById(){
        // TODO: Test goes here...
    }

    @Test
    public void testQueryForPage(){
        // TODO: Test goes here...
    }
}
