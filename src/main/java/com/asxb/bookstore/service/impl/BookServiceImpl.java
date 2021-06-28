package com.asxb.bookstore.service.impl;

import com.asxb.bookstore.mapper.BookMapper;
import com.asxb.bookstore.pojo.Category;
import com.asxb.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}