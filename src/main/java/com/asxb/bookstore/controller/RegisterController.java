package com.asxb.bookstore.controller;

import com.asxb.bookstore.common.ResultInfo;
import com.asxb.bookstore.common.impl.ResultInfoFactory;
import com.asxb.bookstore.service.RegisterService;
import com.asxb.bookstore.service.impl.RegisterServiceImpl;
import com.asxb.bookstore.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {


    @Autowired
    RegisterService registerService;
    @Autowired
    ResultInfoFactory factory;

    @PostMapping("/registerAction")
    public String register(String userName, String password, Model model) {
        ResultInfo resultInfo = factory.getObjectByEmpConstructor();
        resultInfo.setCode(403);

        // 用户名检测
        if (userName.equals("") || userName.isEmpty()) {
            resultInfo.setMsg("用户名不能为空!");
            model.addAttribute("info", resultInfo);
            return "register";
        }

        // 密码检测
        int len = password.length();
        if (len < 6 || len > 10) {
            resultInfo.setMsg("密码长度只能是[6,10]!");
            model.addAttribute("info", resultInfo);
            return "register";

        }

        // 重名检测
        if (registerService.verrifyDupulicate(userName) != null) {
            resultInfo.setMsg("该用户名已存在!");
            model.addAttribute("info", resultInfo);
            return "register";
        }

        // 通过了所有验证。插入数据，完成注册
        registerService.insertService(userName, new MD5().getMD5ofStr(password));
        resultInfo = factory.getSuccessTemplateObject();
        model.addAttribute("info", resultInfo);
        return "register";
    }

}
