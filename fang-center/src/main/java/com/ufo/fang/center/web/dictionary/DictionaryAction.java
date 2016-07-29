package com.ufo.fang.center.web.dictionary;

import com.ufo.fang.center.model.Dictionary;
import com.ufo.fang.center.service.dictionary.DictionaryService;
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
 * Dictionary控制器
 *
 * @author generator
 * @created 2016-07-19
 */
@Controller
@RequestMapping("/dictionary")
public class DictionaryAction extends BaseTemplateAction<Dictionary, Long> {

    @Autowired
    DictionaryService dictionaryService;

    @Override
    protected BaseService<Dictionary, Long> getService() {
        return dictionaryService;
    }

    @RequestMapping("index.htm")
    public String index() throws ServiceException {
        return this.toView("dictionary/dictionaryIndex");
    }

    @RequestMapping("queryForPage.json")
    @ResponseBody
    public Object queryForPage(Integer page, Integer rows) throws ServiceException {
        Map<String, Object> params = new HashMap<>();
        return gridPageResult(getService().queryForPage(params, page, rows));
    }

    @RequestMapping("add.do")
    @ResponseBody
    public Object add(Dictionary dto) throws ServiceException {
        return add(dto);
    }

    @RequestMapping("modify.do")
    @ResponseBody
    public Object modify(Dictionary dto) throws ServiceException {
        return modify(dto);
    }

    @RequestMapping("delete.do")
    @ResponseBody
    public Object delete(Long id) throws ServiceException {
        return delete(id);
    }
}
