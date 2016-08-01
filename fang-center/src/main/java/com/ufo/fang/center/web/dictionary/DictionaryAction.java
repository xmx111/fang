package com.ufo.fang.center.web.dictionary;

import com.ufo.fang.center.model.Dictionary;
import com.ufo.fang.center.service.dictionary.DictionaryService;
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
 * Dictionary控制器
 *
 * @author generator
 * @created 2016-08-01
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
        return this.toView("dictionary/dictionary-index");
    }

    @RequestMapping("operator.htm")
    public String operator(Long id, ModelMap map) throws ServiceException {
        if (id != null)
            map.put("data", getService().queryById(id));
        return this.toView("dictionary/dictionary-operator");
    }

    @RequestMapping("query.json")
    @ResponseBody
    public Object query(Integer page, Integer rows) throws ServiceException {
        Map<String, Object> params = new HashMap<>();
        return gridPageResult(getService().queryForPage(params, page, rows));
    }

    @RequestMapping("save.do")
    @ResponseBody
    public Object save(Dictionary dto) throws ServiceException {
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
