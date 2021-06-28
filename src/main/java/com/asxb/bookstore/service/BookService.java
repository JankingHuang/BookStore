package com.asxb.bookstore.service;

import com.asxb.bookstore.common.BookCustom;
import com.asxb.bookstore.pojo.Book;
import com.asxb.bookstore.pojo.Category;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {

    List<Category> allCategory();

    void addBook(Book book);

    // 查询未上架的图书
    List<Book> findBooksByCustom(BookCustom bookCustom);

    // 按筛选条件查图书总量
    BigDecimal findBooksTotal(BookCustom bookCustom);
}
