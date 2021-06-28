package com.asxb.bookstore.mapper;

import com.asxb.bookstore.pojo.Book;
import com.asxb.bookstore.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BookMapper {

    List<Category> findAllCategory();

    List<Book> findAllBook();

    int updateBookPinyin(Book book);

    void addBook(Book book);
}
