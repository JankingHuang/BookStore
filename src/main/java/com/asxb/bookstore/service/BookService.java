package com.asxb.bookstore.service;

import com.asxb.bookstore.pojo.Book;
import com.asxb.bookstore.pojo.Category;

import java.util.List;

public interface BookService {

    List<Category> allCategory();

    void addBook(Book book);
}
