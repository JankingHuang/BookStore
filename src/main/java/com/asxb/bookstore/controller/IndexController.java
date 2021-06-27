package com.asxb.bookstore.controller;

import com.asxb.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    BookService bookService;

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        // 加载图书分类
        model.addAttribute("categories", bookService.allCategory());
        return "index";
    }

}
