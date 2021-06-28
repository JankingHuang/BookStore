package com.asxb.bookstore.service;

import com.asxb.bookstore.pojo.Book;
import com.asxb.bookstore.pojo.Category;

import java.util.List;
import java.util.Map;

public interface BookService {

    List<Category> allCategory();

    void addBook(Book book);

    List<Book> allBook();

    int updateBookPinyin(Book book);
}
