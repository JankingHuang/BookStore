package com.asxb.bookstore.controller;

import com.asxb.bookstore.common.BookCustom;
import com.asxb.bookstore.common.ResultInfo;
import com.asxb.bookstore.common.impl.ResultInfoFactory;
import com.asxb.bookstore.pojo.Book;
import com.asxb.bookstore.pojo.Category;
import com.asxb.bookstore.service.BookService;
import com.asxb.bookstore.utils.PinYinUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 刘斌
 * @date 2021/6/28 9:32
 */
@Controller
public class BookController {


    @Autowired
    BookService bookService;

    @Autowired
    ResultInfoFactory<List<Book>> factory;

    // 添加图书的动作
    @RequestMapping("/addBookAction")
    public String addBookAction(Book book, Model model) {
        System.out.println(book);
        if (book.getBookName().isEmpty() ||
                book.getBookName().equals("") ||
                book.getCategoryId() == null ||
                book.getBookAuthor().equals("")) {
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

    @RequestMapping(value = "/findBook")
    public String findBook(Model model) {
//        model.addAttribute("categories", bookService.allCategory());
        return "findBook";
    }

    // 渲染未上架图书页面
    @RequestMapping("/listBook1")
    public String listBook_1(Integer pageNum, Integer size, Model model) {
        BookCustom bookCustom = new BookCustom();
        bookCustom.setBookState(1); // 查询未上架图书

//        System.out.println("page = " + pageNum);
//        System.out.println("size = " + size);
        // 初始化时按第一页处理
        if (pageNum == null) pageNum = 1;
        if (size == null) size = 5;

        bookCustom.setPageNum((pageNum - 1) * size);
        bookCustom.setSize(size);

        // 查询数据和总量
        List<Book> books = bookService.findBooksByCustom(bookCustom);
        BigDecimal total = bookService.findBooksTotal(bookCustom);
        ResultInfo<List<Book>> info = factory.getSuccessTemplateObject();
        info.setData(books);

        model.addAttribute("info", info);
        // 计算总页数
        model.addAttribute("size", total.divide(new BigDecimal(size), 0, BigDecimal.ROUND_UP)); // 总页数
        model.addAttribute("page", pageNum); // 当前页
        return "listBook1";
    }

    // 渲染已上架图书页面
    @RequestMapping("/listBook2")
    public String listBook_2(Integer pageNum, Integer size, Model model) {
        BookCustom bookCustom = new BookCustom();
        bookCustom.setBookState(2); // 查询上架图书

//        System.out.println("page = " + pageNum);
//        System.out.println("size = " + size);
        // 初始化时按第一页处理
        if (pageNum == null) pageNum = 1;
        if (size == null) size = 5;

        bookCustom.setPageNum((pageNum - 1) * size);
        bookCustom.setSize(size);

        // 查询数据和总量
        List<Book> books = bookService.findBooksByCustom(bookCustom);
        BigDecimal total = bookService.findBooksTotal(bookCustom);
        ResultInfo<List<Book>> info = factory.getSuccessTemplateObject();
        info.setData(books);

        model.addAttribute("info", info);
        // 计算总页数
        model.addAttribute("size", total.divide(new BigDecimal(size), 0, BigDecimal.ROUND_UP)); // 总页数
        model.addAttribute("page", pageNum); // 当前页
        return "listBook2";
    }

    // 渲染已上架图书页面
    @RequestMapping("/listBook3")
    public String listBook_3(Integer pageNum, Integer size, Model model) {
        BookCustom bookCustom = new BookCustom();
        bookCustom.setBookState(3); // 查询下架图书

//        System.out.println("page = " + pageNum);
//        System.out.println("size = " + size);
        // 初始化时按第一页处理
        if (pageNum == null) pageNum = 1;
        if (size == null) size = 5;

        bookCustom.setPageNum((pageNum - 1) * size);
        bookCustom.setSize(size);

        // 查询数据和总量
        List<Book> books = bookService.findBooksByCustom(bookCustom);
        BigDecimal total = bookService.findBooksTotal(bookCustom);
        ResultInfo<List<Book>> info = factory.getSuccessTemplateObject();
        info.setData(books);

        model.addAttribute("info", info);
        // 计算总页数
        model.addAttribute("size", total.divide(new BigDecimal(size), 0, BigDecimal.ROUND_UP)); // 总页数
        model.addAttribute("page", pageNum); // 当前页
        return "listBook3";
    }

    @RequestMapping("/bookUp")
    public String bookUp(Long id, Model model) {
        bookService.bookUp(new BigDecimal(id));

        return "forward:listBook1";
    }

    @RequestMapping("/bookDown")
    public String bookDown(Long id, Model model) {
        bookService.bookDown(new BigDecimal(id));

        return "forward:listBook2";
    }

    @RequestMapping("/deleteBookById")
    public String deleteBookById(Long id, Model model) {
        bookService.deleteBookById(new BigDecimal(id));

        return "forward:listBook1";
    }

    @RequestMapping("/editBook")
    public String editBook(Long id, Model model) {

        Book book = bookService.findBookById(new BigDecimal(id));
        List<Category> categories = bookService.allCategory();

        // 遍历寻找当前图书的类型名称
        for (Category category : categories) {
            if (category.getId().equals(book.getCategoryId())) {
                model.addAttribute("categoryName", category.getCategoryName());
                break;
            }
        }

        model.addAttribute("book", book);
        model.addAttribute("categories", categories);

        return "editBook";
    }

    @RequestMapping("/editBookAction")
    public String editBookAction(Book book, Model model) {
//        System.out.println(book);
        bookService.updateBook(book);
        return "redirect:listBook1";
    }

    @RequestMapping("/bookCategory")
    public String bookCategory(Long id, Model model) {


        return "index";
    }
}
