package com.ufo.fang.center.web.gradingInfo;

import com.ufo.fang.center.model.GradingInfo;
import com.ufo.fang.center.service.gradingInfo.GradingInfoService;
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
 * GradingInfo控制器
 *
 * @author generator
 * @created 2016-07-18
 */
@Controller
@RequestMapping("/gradingInfo")
public class GradingInfoAction extends BaseTemplateAction<GradingInfo, Long> {

    @Autowired
    GradingInfoService gradingInfoService;

    @Override
    protected BaseService<GradingInfo, Long> getService() {
        return gradingInfoService;
    }

    @RequestMapping("index.htm")
    public String index() throws ServiceException {
        return this.toView("gradingInfo/gradingInfoIndex");
    }

    @RequestMapping("queryForPage.json")
    @ResponseBody
    public Object queryForPage(Integer page, Integer rows) throws ServiceException {
        Map<String, Object> params = new HashMap<>();
        return gridResult(getService().queryForPage(params, page, rows));
    }

    @RequestMapping("add.do")
    @ResponseBody
    public Object add(GradingInfo dto) throws ServiceException {
        return add(dto);
    }

    @RequestMapping("modify.do")
    @ResponseBody
    public Object modify(GradingInfo dto) throws ServiceException {
        return modify(dto);
    }

    @RequestMapping("delete.do")
    @ResponseBody
    public Object delete(Long id) throws ServiceException {
        return delete(id);
    }
}
