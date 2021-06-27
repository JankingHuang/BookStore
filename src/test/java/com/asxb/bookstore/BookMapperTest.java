package com.asxb.bookstore;

import com.asxb.bookstore.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 刘斌
 * @date 2021/6/27 16:20
 */
@SpringBootTest
public class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    public void findCategoryTest() {

        System.out.println(bookMapper.findAllCategory());
    }
}
