package com.ufo.fang.center.web.collect;

import com.ufo.fang.center.model.HouseCount;
import com.ufo.fang.center.service.housecount.HouseCountService;
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
 * HouseCount控制器
 *
 * @author generator
 * @created 2016-07-19
 */
@Controller
@RequestMapping("/collect/houseCount")
public class HouseCountAction extends BaseTemplateAction<HouseCount, Long> {

    @Autowired
    HouseCountService houseCountService;

    @Override
    protected BaseService<HouseCount, Long> getService() {
        return houseCountService;
    }

    @RequestMapping("index.htm")
    public String index() throws ServiceException {
        return this.toView("houseCount/houseCountIndex");
    }

    @RequestMapping("queryForPage.json")
    @ResponseBody
    public Object queryForPage(Integer page, Integer rows) throws ServiceException {
        Map<String, Object> params = new HashMap<>();
        return gridPageResult(getService().queryForPage(params, page, rows));
    }

    @RequestMapping("add.do")
    @ResponseBody
    public Object add(HouseCount dto) throws ServiceException {
        return add(dto);
    }

    @RequestMapping("modify.do")
    @ResponseBody
    public Object modify(HouseCount dto) throws ServiceException {
        return modify(dto);
    }

    @RequestMapping("delete.do")
    @ResponseBody
    public Object delete(Long id) throws ServiceException {
        return delete(id);
    }
}
