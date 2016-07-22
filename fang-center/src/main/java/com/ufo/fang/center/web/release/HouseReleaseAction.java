package com.ufo.fang.center.web.release;

import com.ufo.fang.center.model.HouseRelease;
import com.ufo.fang.center.service.houserelease.HouseReleaseService;
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
 * HouseRelease控制器
 *
 * @author generator
 * @created 2016-07-19
 */
@Controller
@RequestMapping("/release/houseRelease")
public class HouseReleaseAction extends BaseTemplateAction<HouseRelease, Long> {

    @Autowired
    HouseReleaseService houseReleaseService;

    @Override
    protected BaseService<HouseRelease, Long> getService() {
        return houseReleaseService;
    }

    @RequestMapping("index.htm")
    public String index() throws ServiceException {
        return this.toView("houseRelease/houseReleaseIndex");
    }

    @RequestMapping("queryForPage.json")
    @ResponseBody
    public Object queryForPage(Integer page, Integer rows) throws ServiceException {
        Map<String, Object> params = new HashMap<>();
        return gridPageResult(getService().queryForPage(params, page, rows));
    }

    @RequestMapping("add.do")
    @ResponseBody
    public Object add(HouseRelease dto) throws ServiceException {
        return add(dto);
    }

    @RequestMapping("modify.do")
    @ResponseBody
    public Object modify(HouseRelease dto) throws ServiceException {
        return modify(dto);
    }

    @RequestMapping("delete.do")
    @ResponseBody
    public Object delete(Long id) throws ServiceException {
        return delete(id);
    }
}
