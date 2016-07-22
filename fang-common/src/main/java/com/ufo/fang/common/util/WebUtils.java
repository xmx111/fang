package com.ufo.fang.common.util;

import com.sun.xml.internal.ws.client.RequestContext;
import com.ufo.fang.common.mvc.xss.XssRequestWrapper;
import freemarker.ext.beans.HashAdapter;
import freemarker.ext.servlet.HttpRequestHashModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/19
 */
public class WebUtils {

    protected static final Logger logger = LoggerFactory.getLogger(WebUtils.class);

    public WebUtils() {
    }

    public static HttpServletRequest getRequest(Object request) {
        HttpServletRequest req;
        if(request instanceof HttpServletRequest) {
            req = (HttpServletRequest)request;
        } else if(request instanceof HashAdapter) {
            req = ((HttpRequestHashModel)((HashAdapter)request).getTemplateModel()).getRequest();
        } else {
            if(!(request instanceof RequestContext)) {
                throw new IllegalArgumentException("无法解析HttpServletRequest: " + request);
            }

            req = (HttpServletRequest)ObjectUtils.getFieldValue(request, "request");
        }

        return req;
    }

    private static Object getValue(HttpServletRequest req, String name) {
        Object value = req.getAttribute(name);
        if(StringUtils.isEmpty(value)) {
            return value;
        } else {
            String value1 = req.getParameter(name);
            if(!StringUtils.isEmpty(value)) {
                return value1;
            } else {
                value = req.getSession().getAttribute(name);
                return StringUtils.isEmpty(value) ? value : req.getServletContext().getAttribute(name);
            }
        }
    }

    public static Object getValue(Object request, String name) {
        return getValue(getRequest(request), name);
    }

    static Date getDate(HttpServletRequest req, String name, Date defaultValue) {
        Object value = getValue(req, name);
        Date date = defaultValue;
        if(value instanceof Date) {
            date = (Date)value;
        } else if(value instanceof String) {
            date = DateUtils.toDate(value.toString().trim(), DateUtils.TIME_PATTERN);
        }

        if(date != null) {
            req.getSession().setAttribute(name, date);
        }

        return date;
    }

    public static String sign(String secret, Object timestamp, String paramsMd5) {
        String sign = StringUtils.md5(new String[]{secret, timestamp.toString(), paramsMd5, secret});
        logger.trace("timestamp={}, paramsMd5={}, sign={}", new Object[]{timestamp, paramsMd5, sign});
        return sign;
    }

    public static String paramsMd5(Object request) {
        HttpServletRequest req = getRequest(request);
        XssRequestWrapper wrapper = (XssRequestWrapper)req.getAttribute("__xss_req");
        Map tmp = wrapper == null?req.getParameterMap():wrapper.getParameterMap0();
        Object paramsMap = tmp instanceof TreeMap ?tmp:new TreeMap(tmp);
        ArrayList params = new ArrayList(((Map)paramsMap).size() + 4);
        Iterator var7 = ((Map)paramsMap).entrySet().iterator();

        while(var7.hasNext()) {
            Map.Entry entry = (Map.Entry)var7.next();
            params.add((String)entry.getKey());
            String[] var11;
            int var10 = (var11 = (String[])entry.getValue()).length;

            for(int var9 = 0; var9 < var10; ++var9) {
                String value = var11[var9];
                params.add(value);
            }
        }

        return StringUtils.md5(params);
    }

    public static Map<String, Object> getParameterMap(HttpServletRequest request) throws UnsupportedEncodingException {
        Map parameters = request.getParameterMap();
        HashMap params = new HashMap();
        String value = "";

        String key;
        for(Iterator var5 = parameters.entrySet().iterator(); var5.hasNext(); params.put(key, value)) {
            Map.Entry entry = (Map.Entry)var5.next();
            key = (String)entry.getKey();
            Object obj = entry.getValue();
            if(obj == null) {
                value = "";
            } else if(!(obj instanceof String[])) {
                value = value.toString();
            } else {
                String[] values = (String[])obj;

                for(int i = 0; i < values.length; ++i) {
                    value = values[i] + ",";
                }

                value = value.substring(0, value.length() - 1);
            }
        }

        return params;
    }

    private static Integer getParameterInt(HttpServletRequest request, String name, Integer defaultValue) {
        String value = StringUtils.trim(request.getParameter(name));
        if(value != null && !value.isEmpty()) {
            Integer result = ObjectUtils.toInteger(value);
            return result == null?defaultValue:result;
        } else {
            return defaultValue;
        }
    }
}
