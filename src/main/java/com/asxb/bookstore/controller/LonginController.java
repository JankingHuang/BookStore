package com.asxb.bookstore.controller;

import com.asxb.bookstore.common.ResultInfo;
import com.asxb.bookstore.common.impl.ResultInfoFactory;
import com.asxb.bookstore.service.LoginService;
import com.asxb.bookstore.service.impl.LoginServiceImpl;
import com.asxb.bookstore.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LonginController {

    @Autowired
    ResultInfoFactory factory;

    @Autowired
    LoginService loginService;

    @PostMapping("/loginAction")
    public String login(String userName, String password, Model model) {

        if (loginService.loginSelect(userName, new MD5().getMD5ofStr(password)) != null) {
            System.out.println("...");
            return "index";
        }

        ResultInfo info = factory.getObjectByEmpConstructor();
        info.setMsg("用户名或密码错误...");
        model.addAttribute("info", info);

        return "login";
    }
}

