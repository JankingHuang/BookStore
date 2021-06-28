package com.asxb.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 刘斌
 * @date 2021/6/28 9:32
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/addBookAction")
    public String addBook() {

        return "addBook";
    }
}
