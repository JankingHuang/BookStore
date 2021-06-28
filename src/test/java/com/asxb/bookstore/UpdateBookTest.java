package com.asxb.bookstore;

import com.asxb.bookstore.mapper.BookMapper;
import com.asxb.bookstore.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 刘斌
 * @date 2021/6/28 22:35
 */
@SpringBootTest
public class UpdateBookTest {

    @Autowired
    BookMapper bookMapper;

    // 测试成功
    @Test
    public void updateTest() {
        Book book = new Book();
        book.setBookId(5L);
        book.setBookName("深入理解JVM虚拟机");
        book.setBookPrice(100.0f);
        bookMapper.updateBook(book);

    }

}
