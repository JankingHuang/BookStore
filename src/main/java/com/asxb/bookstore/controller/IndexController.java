package com.asxb.bookstore.controller;

import com.asxb.bookstore.common.BookCustom;
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
    public String index(Long id, Model model) {
        // 加载图书分类
        model.addAttribute("categories", bookService.allCategory());

        // 加载新上架图书
        BookCustom bookCustom = new BookCustom();
        bookCustom.setBookState(2); // 已上架
        bookCustom.setSortField("deploy_datetime"); // 时间倒序
        bookCustom.setSortType("DESC");
        bookCustom.setPageNum(0); // 取5本
        bookCustom.setSize(5);
        if (id != null) {
            bookCustom.setCategoryId(id);
        }

        model.addAttribute("newBooks", bookService.findBooksByCustom(bookCustom));

        // 查询热销书籍
        bookCustom.setSortField("sales_volume");
        model.addAttribute("hotBooks", bookService.findBooksByCustom(bookCustom));

        return "index";
    }

}
