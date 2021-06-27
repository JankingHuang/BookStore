package com.asxb.bookstore.controller;

import com.asxb.bookstore.common.ResultInfo;
import com.asxb.bookstore.common.impl.ResultInfoFactory;
import com.asxb.bookstore.pojo.User;
import com.asxb.bookstore.service.LoginService;
import com.asxb.bookstore.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LonginController {

    @Autowired
    ResultInfoFactory factory;

    @Autowired
    LoginService loginService;

    @PostMapping("/loginAction")
    public String login(String userName, String password, Model model, HttpSession session) {

        User user = loginService.loginSelect(userName, new MD5().getMD5ofStr(password));
        if (user != null) {
            session.setAttribute("user", user);
            if (user.getType() == 1) {
                return "console1";
            }
            System.out.println(session.getAttribute("user"));
            return "index";
        }

        ResultInfo info = factory.getObjectByEmpConstructor();
        info.setMsg("用户名或密码错误...");
        model.addAttribute("info", info);

        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("logout...");
        session.invalidate();
        return "index";
    }
}

