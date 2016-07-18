package com.ufo.fang.center.web.collectWebsite;

import com.ufo.fang.center.model.CollectWebsite;
import com.ufo.fang.center.service.collectWebsite.CollectWebsiteService;
import com.ufo.fang.common.service.BaseService;
import com.ufo.fang.common.web.BaseTemplateAction;
import com.ufo.fang.common.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/***
 * CollectWebsite控制器
 *
 * @author generator
 * @created 2016-07-18
 */
@Controller
@RequestMapping("/collectWebsite")
public class CollectWebsiteAction extends BaseTemplateAction<CollectWebsite, Long> {

    @Autowired
    CollectWebsiteService collectWebsiteService;

    @Override
    protected BaseService<CollectWebsite, Long> getService() {
        return collectWebsiteService;
    }

    @RequestMapping("index.htm")
    public String index() throws ServiceException {
        return this.toView("collectWebsite/collectWebsiteIndex");
    }

    @RequestMapping("queryForPage.json")
    @ResponseBody
    public Object queryForPage(Integer page, Integer rows) throws ServiceException {
        Map<String, Object> params = new HashMap<>();
        return gridResult(getService().queryForPage(params, page, rows));
    }

    @RequestMapping("add.do")
    @ResponseBody
    public Object add(CollectWebsite dto) throws ServiceException {
        return add(dto);
    }

    @RequestMapping("modify.do")
    @ResponseBody
    public Object modify(CollectWebsite dto) throws ServiceException {
        return modify(dto);
    }

    @RequestMapping("delete.do")
    @ResponseBody
    public Object delete(Long id) throws ServiceException {
        return delete(id);
    }
}
