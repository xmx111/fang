package com.ufo.fang.common.mvc.xss;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 防Xss攻击
 *
 * @author hekang
 * @created 2016/7/20
 */
public class XssFilter implements Filter {

    protected static final org.slf4j.Logger logger = LoggerFactory.getLogger(XssFilter.class);

    public XssFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String method = ((HttpServletRequest)request).getMethod();
        if(((ServletRequest)request).getAttribute("__xss_req") == null) {
            request = new XssRequestWrapper((HttpServletRequest)request);
        }

        if(response instanceof HttpServletResponse) {
            HttpServletResponse alteredResponse = (HttpServletResponse)response;
            this.addHeadersFor200Response(alteredResponse);
        }

        if(HttpMethod.OPTIONS.name().equals(method.toUpperCase())) {
            this.logger.info("OPTIONS跨域处理");
        } else {
            chain.doFilter((ServletRequest)request, response);
        }
    }

    private void addHeadersFor200Response(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "1728000");
        response.addHeader("P3P", "CP=CAO PSA OUR");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,application/octet-stream, TOKEN");
        response.setStatus(200);
    }

    public void destroy() {
    }
}
