package com.ufo.fang.common.mvc.xss;

import com.ufo.fang.common.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/19
 */
public class XssRequestWrapper extends HttpServletRequestWrapper {
    protected static final Logger logger = LoggerFactory.getLogger(XssRequestWrapper.class);
    private static Map<Pattern, String> patterns = new LinkedHashMap();
    public static final String reqAttrNameXss = "__xss_req";
    private Map<String, String[]> parameterMap0;
    private Map<String, String[]> parameterMap;
    private Map<String, Object> info = new LinkedHashMap();
    private boolean modify = false;

    static {
        patterns.put(Pattern.compile("<script>(.*?)</script>", 2), "");
        patterns.put(Pattern.compile("<((ifram)|(fram\\w+)|(script))\\s+.*src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", 42), "");
        patterns.put(Pattern.compile("<((ifram)|(fram\\w+)|(script))\\s+.*src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", 42), "");
        patterns.put(Pattern.compile("</script>", 2), "");
        patterns.put(Pattern.compile("<script(.*?)>", 42), "");
        patterns.put(Pattern.compile("eval\\((.*?)\\)", 42), "");
        patterns.put(Pattern.compile("expression\\((.*?)\\)", 42), "");
        patterns.put(Pattern.compile("javascript:", 2), "");
        patterns.put(Pattern.compile("vbscript:", 2), "");
        patterns.put(Pattern.compile("onload(.*?)=", 42), "");
        patterns.put(Pattern.compile("onfocus(.*?)", 42), "");
        patterns.put(Pattern.compile("\\w*((\\%27)|(\'))((\\%6F)|o|(\\%4F))((\\%72)|r|(\\%52))", 10), "");
        patterns.put(Pattern.compile("exec(\\s|\\+)+(s|x)p\\w+", 10), "");
        patterns.put(Pattern.compile("((\\%27)|(\'))union", 10), "");
        patterns.put(Pattern.compile("((\\%27)|(\'))update", 10), "");
        patterns.put(Pattern.compile("((\\%27)|(\'))insert", 10), "");
        patterns.put(Pattern.compile("((\\%27)|(\'))delete", 10), "");
        patterns.put(Pattern.compile("((\\%27)|(\'))drop", 10), "");
        patterns.put(Pattern.compile("(\\%27)|(\\-\\-)|(\\%23)", 10), "");
    }

    public static XssRequestWrapper getXssRequestWrapper(HttpServletRequest request) {
        XssRequestWrapper wrapper = (XssRequestWrapper)request.getAttribute("__xss_req");
        if(wrapper == null) {
            throw new IllegalArgumentException("XssRequestWrapper=null");
        } else {
            return wrapper;
        }
    }

    static String strip(String value) {
        if(value != null && !value.isEmpty()) {
            String tmp1 = value;

            while(true) {
                String tmp2 = HtmlUtils.htmlUnescape(tmp1);

                Map.Entry entry;
                for(Iterator var4 = patterns.entrySet().iterator(); var4.hasNext(); tmp2 = ((Pattern)entry.getKey()).matcher(tmp2).replaceAll((String)entry.getValue())) {
                    entry = (Map.Entry)var4.next();
                }

                if(tmp2.equals(value)) {
                    return value;
                }

                tmp1 = tmp2;
                value = tmp2;
            }
        } else {
            return value;
        }
    }

    private String[] strip(String[] values) {
        String[] result = new String[values.length];

        for(int i = values.length - 1; i >= 0; --i) {
            String value = values[i];
            String ret = strip(value);
            if(!this.modify && value != ret && !value.equals(ret)) {
                this.modify = true;
            }

            result[i] = ret;
        }

        return result;
    }

    public XssRequestWrapper(HttpServletRequest request) {
        super(request);
        this.setAttribute("__xss_req", this);
    }

    public Map<String, String[]> getParameterMap() {
        if(this.parameterMap0 == null) {
            this.parameterMap0 = super.getParameterMap();
            this.parameterMap = new HashMap();
            this.info.put("url", this.getRequestURL().toString());
            this.info.put("query", this.getQueryString());
            this.info.put("referer", this.getHeader("Referer"));
            this.info.put("ori", this.parameterMap0);
            this.info.put("strip", this.parameterMap);
            Iterator var2 = this.parameterMap0.entrySet().iterator();

            while(var2.hasNext()) {
                Map.Entry entry = (Map.Entry)var2.next();
                String name = (String)entry.getKey();
                this.parameterMap.put(name, this.strip((String[])entry.getValue()));
            }

            if(this.modify) {
                logger.info("XSS成功拦截 {}", new Object[]{JsonUtils.writeValueAsString(this.info)});
            }
        }

        return this.parameterMap;
    }

    public String getParameter(String name) {
        String[] values = this.getParameterValues(name);
        return values != null && values.length > 0?values[0]:null;
    }

    public String[] getParameterValues(String name) {
        return (String[])this.getParameterMap().get(name);
    }

    public Map<String, String[]> getParameterMap0() {
        this.getParameterMap();
        return this.parameterMap0;
    }

    public String getParameter0(String name) {
        String[] values = this.getParameterValues0(name);
        return values != null && values.length > 0?values[0]:null;
    }

    public String[] getParameterValues0(String name) {
        return (String[])this.getParameterMap0().get(name);
    }
}

