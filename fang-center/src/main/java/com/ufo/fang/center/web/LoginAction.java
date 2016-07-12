package com.ufo.fang.center.web;

import com.ufo.fang.common.web.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 登录页控制器
 *
 * @author hekang
 * @created 2016/1/15
 */
@Controller
public class LoginAction extends BaseAction {

    @RequestMapping("/login.htm")
    public String login() {
        return toView("login");
    }

    @RequestMapping("/doLogin.htm")
    public String doLogin() {
        return redirect("/index.htm");
    }
}
