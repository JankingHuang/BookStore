package com.asxb.bookstore.mapper;

import com.asxb.bookstore.common.BookCustom;
import com.asxb.bookstore.pojo.Book;
import com.asxb.bookstore.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    List<Category> findAllCategory();

    void addBook(Book book);

    List<Book> findBooks(BookCustom bookCustom);

    BigDecimal totalBooks(BookCustom bookCustom);

    @Update("update t_book set book_state = 2 where book_id = #{id}")
    void bookUp(@Param("id") BigDecimal id);

    @Update("update t_book set book_state = 3 where book_id = #{id}")
    void bookDown(@Param("id") BigDecimal id);
}
