package com.ufo.fang.center.test.web.gradinginfo;

import com.ufo.fang.center.test.junit.AbstractWebTest;
import com.ufo.fang.common.util.JsonUtils;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
* GradingInfoAction Tester.
*
* @author <Authors name>
    * @since <pre>2016-07-19</pre>
    * @version 1.0
    */
    public class GradingInfoActionTest extends AbstractWebTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: index()
    *
    */
    @Test
    public void testIndex() throws Exception {
        logger.info("测试用户管理首页");
        String html = mvc.perform(get("/gradingInfo/index.htm").with(apiSignRequestPostProcessor))
        .andReturn().getResponse().getContentAsString();
        System.out.println(html);
        logger.info("html:\n{}", JsonUtils.writerWithDefaultPrettyPrinter(html));
    }

    /**
    *
    * Method: findByPage(Integer pageNum, Integer pageSize)
    *
    */
    @Test
    public void testFindByPage() throws Exception {
        //TODO: Test goes here...
    }

    /**
    *
    * Method: update(fang dto)
    *
    */
    @Test
    public void testUpdate() throws Exception {
        //TODO: Test goes here...
    }

    /**
    *
    * Method: save(fang dto)
    *
    */
    @Test
    public void testSave() throws Exception {
        //TODO: Test goes here...
    }

    /**
    *
    * Method: delete(Long id)
    *
    */
    @Test
    public void testDelete() throws Exception {
        //TODO: Test goes here...
    }


}
