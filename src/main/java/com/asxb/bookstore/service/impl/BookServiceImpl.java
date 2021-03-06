package com.asxb.bookstore.service.impl;

import com.asxb.bookstore.common.BookCustom;
import com.asxb.bookstore.mapper.BookMapper;
import com.asxb.bookstore.pojo.Book;
import com.asxb.bookstore.pojo.Category;
import com.asxb.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 刘斌
 * @date 2021/6/27 16:23
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Category> allCategory() {
        return bookMapper.findAllCategory();
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public List<Book> findBooksByCustom(BookCustom bookCustom) {
        return bookMapper.findBooks(bookCustom);
    }

    @Override
    public BigDecimal findBooksTotal(BookCustom bookCustom) {
        return bookMapper.totalBooks(bookCustom);
    }

    @Override
    public void bookUp(BigDecimal id) {
        bookMapper.bookUp(id);
    }

    @Override
    public void bookDown(BigDecimal id) {
        bookMapper.bookDown(id);
    }

    @Override
    public void deleteBookById(BigDecimal id) {
        bookMapper.deleteBookById(id);
    }

    @Override
    public Book findBookById(BigDecimal id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }
}
