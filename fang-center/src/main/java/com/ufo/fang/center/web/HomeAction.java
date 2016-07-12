package com.ufo.fang.center.web;

import com.ufo.fang.common.web.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return forward("login.htm");
    }

    @RequestMapping("/index.htm")
    public String index() {
        return toView("index");
    }

    @RequestMapping("/main.htm")
    public String main() {
        return toView("main");
    }

}
