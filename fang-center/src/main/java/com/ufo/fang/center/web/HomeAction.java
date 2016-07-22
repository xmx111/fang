package com.ufo.fang.center.web;

import com.ufo.fang.common.web.BaseAction;
import com.ufo.fang.common.web.easyui.DataGridResult;
import com.ufo.fang.common.web.jqgrid.PageDataGridResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 首页
 *
 * @author hekang
 * @created 2016/1/14
 */
@Controller
public class HomeAction extends BaseAction {

    @RequestMapping("/")
    public String welcome() {
        return toView("index2");
    }

    @RequestMapping("/index.htm")
    public String index() {
        return toView("index");
    }

    @RequestMapping("/main.htm")
    public String main() {
        return toView("main");
    }

    @RequestMapping("/test.htm")
    public String test() {
        return toView("test");
    }

    @RequestMapping("/test.json")
    @ResponseBody
    public Object testJson() {
        Map<String, String> map = new HashMap();
        List<Map<String, String>> list = new ArrayList<>();
        map.put("id", "1");
        map.put("orderdate", "2013-10-01");
        map.put("customer", "customer");
        map.put("price", "200.00");
        map.put("vat", "10.00");
        map.put("completed", "true");
        map.put("shipment", "TN");
        map.put("total", "210.00");
        map.put("id", "2");
        list.add(map);
        map = new HashMap<>();
        map.put("orderdate", "2013-10-01");
        map.put("customer", "customer");
        map.put("price", "200.00");
        map.put("vat", "10.00");
        map.put("completed", "true");
        map.put("shipment", "TN");
        map.put("total", "210.00");
        list.add(map);
        map = new HashMap<>();
        map.put("id", "3");
        map.put("orderdate", "2013-10-01");
        map.put("customer", "customer");
        map.put("price", "200.00");
        map.put("vat", "10.00");
        map.put("completed", "true");
        map.put("shipment", "TN");
        map.put("total", "210.00");
        list.add(map);
        map = new HashMap<>();
        map.put("id", "4");
        map.put("orderdate", "2013-10-01");
        map.put("customer", "customer");
        map.put("price", "200.00");
        map.put("vat", "10.00");
        map.put("completed", "true");
        map.put("shipment", "TN");
        map.put("total", "210.00");
        list.add(map);
        map = new HashMap<>();
        map.put("id", "5");
        map.put("orderdate", "2013-10-01");
        map.put("customer", "customer");
        map.put("price", "200.00");
        map.put("vat", "10.00");
        map.put("completed", "true");
        map.put("shipment", "TN");
        map.put("total", "210.00");
        list.add(map);
        PageDataGridResult<Map<String, String>> ret = new PageDataGridResult<>();
        ret.setRows(list);
        ret.setPage(1);
        ret.setTotal(1);
        ret.setRecords(5);

        Map<String, String> map1 = new HashMap<>();
        map1.put("id", "6");
        map1.put("orderdate", "2013-10-01");
        map1.put("customer", "customer");
        map1.put("price", "200.00");
        map1.put("vat", "10.00");
        map1.put("completed", "true");
        map1.put("shipment", "TN");
        map1.put("total", "210.00");
        ret.setUserdata(map1);
        return ret;
    }

}
