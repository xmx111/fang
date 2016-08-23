package com.ufo.fang.center.web.tag.dic;

import com.ufo.fang.center.util.KeyValueUtil;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 字典下拉选择框控件
 * @author hekang@hitao.com
 * @created 2016年2月25日 下午5:40:32
 */
public class DropDownSelectBox implements TemplateDirectiveModel {

    @Autowired
    FreeMarkerConfigurer freemarkerConfig;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Template template = freemarkerConfig.getConfiguration().getTemplate("/iframe/widget/dic/dropDownSelectBox.ftl");
        String keyValueType = getParam(params, "keyValueType");
        String key = getParam(params, "key");
        String value = getParam(params, "value");
        String isShowPlease = getParam(params, "isShowPlease", "true");
        String isShowBlank = getParam(params, "isShowBlank");
        String id = getParam(params, "id");
        String name = getParam(params, "name");
        String clazz = getParam(params, "class");
        String disabled = getParam(params, "disabled");
        String style = getParam(params, "style");
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("keyValueList", KeyValueUtil.getKeyValueList(keyValueType));
        ret.put("key", key);
        ret.put("value", value);
        ret.put("isShowPlease", isShowPlease);
        ret.put("isShowBlank", isShowBlank);
        ret.put("id", id);
        ret.put("name", name);
        ret.put("class", clazz);
        ret.put("disabled", disabled);
        ret.put("style", style);
        template.process(ret, env.getOut());
    }

    String getParam(Map params,String key) {
        return getParam(params, key, null);
    }

    String getParam(Map params,String key, String defaultValue) {
        Object value = params.get(key);
        return value == null ? defaultValue : value.toString();
    }
}
