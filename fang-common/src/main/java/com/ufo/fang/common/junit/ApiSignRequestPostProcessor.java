package com.ufo.fang.common.junit;

import com.ufo.fang.common.util.StringUtils;
import com.ufo.fang.common.util.WebUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/19
 */
public class ApiSignRequestPostProcessor implements RequestPostProcessor {

    protected final Logger logger = LogManager.getLogger(this.getClass());
    @Value("${client.appId:1}")
    private Long appId;
    @Value("${client.secret:junit-test}")
    private String secret;

    public ApiSignRequestPostProcessor() {
    }

    public Long getAppId() {
        return this.appId;
    }

    public String getSecret() {
        return this.secret;
    }

    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
        request.addHeader("appId", this.appId);
        Long timestamp = Long.valueOf(System.currentTimeMillis());
        request.addHeader("timestamp", timestamp);
        String paramsMd5 = WebUtils.paramsMd5(request);
        String sign = WebUtils.sign(this.secret, timestamp, paramsMd5);
        request.addHeader("sign", sign);
        String url = request.getRequestURI();
        String queryString = request.getQueryString();
        if(StringUtils.isNotEmpty(queryString)) {
            url = url + '?' + queryString;
        }

        this.logger.debug("junit调用url={}, 签名header：appId={}, timestamp={}, paramsMd5={}, sign={}, secret={}", new Object[]{url, this.appId, timestamp, paramsMd5, sign, this.secret});
        return request;
    }
}
