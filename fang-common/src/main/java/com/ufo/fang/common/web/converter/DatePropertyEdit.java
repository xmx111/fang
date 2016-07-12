package com.ufo.fang.common.web.converter;

import com.ufo.fang.common.util.DateUtils;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/** 
* 类名称：DatePropertyEdit 
* 类描述： 自定绑定日期
* 
* 
* 创建人：Duzj
* 创建时间：2012-4-19 上午10:19:13 
* @version 
* 
*/
@SuppressWarnings("rawtypes")
public class DatePropertyEdit extends PropertyEditorSupport {

    private String format = DateUtils.TIME_PATTERN;

    private Class cls = Date.class;

    public DatePropertyEdit(Class cls) {
        this.cls = cls;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setAsText(String value) {
        setValue(DateUtils.toDate(value, value.trim().length() > 10 ? DateUtils.TIME_PATTERN : DateUtils.DATE_FMT_3));
    }

    public String getAsText() {
        return DateUtils.formatDate((Date) getValue(), format);
    }
}
