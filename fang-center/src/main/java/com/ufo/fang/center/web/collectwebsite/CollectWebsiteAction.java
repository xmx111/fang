package com.ufo.fang.center.web.collectwebsite;

import com.ufo.fang.center.model.CollectWebsite;
import com.ufo.fang.center.service.collectwebsite.CollectWebsiteService;
import com.ufo.fang.common.service.BaseService;
import com.ufo.fang.common.web.BaseTemplateAction;
import com.ufo.fang.common.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/***
 * CollectWebsite控制器
 *
 * @author generator
 * @created 2016-08-01
 */
@Controller
@RequestMapping("/collectwebsite")
public class CollectWebsiteAction extends BaseTemplateAction<CollectWebsite, Long> {

    @Autowired
    CollectWebsiteService collectWebsiteService;

    @Override
    protected BaseService<CollectWebsite, Long> getService() {
        return collectWebsiteService;
    }

    @RequestMapping("index.htm")
    public String index() throws ServiceException {
        return this.toView("collectwebsite/collect-Website-index");
    }

    @RequestMapping("operator.htm")
    public String operator(Long id, ModelMap map) throws ServiceException {
        if (id != null)
            map.put("data", getService().queryById(id));
        return this.toView("collectwebsite/collect-Website-operator");
    }

    @RequestMapping("query.json")
    @ResponseBody
    public Object query(Integer page, Integer rows) throws ServiceException {
        Map<String, Object> params = new HashMap<>();
        return gridPageResult(getService().queryForPage(params, page, rows));
    }

    @RequestMapping("save.do")
    @ResponseBody
    public Object save(CollectWebsite dto) throws ServiceException {
        if (dto.getId() == null)
            return add(dto);
        else
            return modify(dto);
    }

    @RequestMapping("delete.do")
    @ResponseBody
    public Object delete(Long id) throws ServiceException {
        return delete(id);
    }
}
