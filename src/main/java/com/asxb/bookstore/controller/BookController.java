package com.asxb.bookstore.controller;

import com.asxb.bookstore.common.ResultInfo;
import com.asxb.bookstore.common.impl.ResultInfoFactory;
import com.asxb.bookstore.pojo.Book;
import com.asxb.bookstore.service.BookService;
import com.asxb.bookstore.utils.PinYinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import java.util.Date;

/**
 * @author 刘斌
 * @date 2021/6/28 9:32
 */
@Controller
public class BookController {


    @Autowired
    BookService bookService;

    @Autowired
    ResultInfoFactory factory;

    // 添加图书的动作
    @RequestMapping("/addBookAction")
    public String addBookAction(Book book, Model model) {
        System.out.println(book);
        if (book.getBookName().isEmpty() ||
                book.getBookName().equals("") ||
                book.getCategoryId() == null ||
                book.getBookAuthor().equals(""))
        {
            ResultInfo info = factory.getObjectByEmpConstructor();
            info.setMsg("输入信息不全面或者类型有误!");
            info.setCode(403);
            model.addAttribute("info", info);
            return "error_page/error";
        }

        book.setDeployDatetime(new Date());
        book.setNamePinyin(PinYinUtil.toPinyin(book.getBookName()));
        bookService.addBook(book);
        model.addAttribute("info", factory.getSuccessTemplateObject());

        return "addBook";
    }

    // 进入添加页面时渲染页面
    @RequestMapping("/addBook")
    public String addBook(Model model) {
        model.addAttribute("categories", bookService.allCategory());
        return "addBook";
    }

    @RequestMapping(value = "/findBook", method = {RequestMethod.POST, RequestMethod.GET})
    public String findBook(Model model) {
//        model.addAttribute("categories", bookService.allCategory());
        return "findBook";
    }
}
