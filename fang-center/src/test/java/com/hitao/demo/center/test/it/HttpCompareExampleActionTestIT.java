package com.ufo.fang.center.test.it;

import com.ufo.fang.center.test.junit.AbstractWebTest;

import java.util.HashMap;
import java.util.Map;

/***
 * 接口对比集成测试示例
 *
 * @author hekang
 * @created 2016/1/20
 */
public class HttpCompareExampleActionTestIT {

    public void testCompare() throws Exception {
        String localURL = "http://localhost/xxx/xx";
        String remoteURL = "http://xx.x.x.x/xxx/xx";

        Map<String, Object> params = new HashMap<>();
        params.put("param1", "0");
        params.put("param2", "2");

        // 取本地返回json

        // 检查必须返回值

        // 比对本地和远程接口返回json是否一致
    }
}
