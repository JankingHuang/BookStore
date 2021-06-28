package com.asxb.bookstore;

import com.asxb.bookstore.common.BookCustom;
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

    // 动态sql查询书籍测试
    @Test
    public void findBooksTest() {

        BookCustom bookCustom = new BookCustom();
//        bookCustom.setSortField("");
//        bookCustom.setCategoryId(11L);

        bookCustom.setBookState(1);
        System.out.println(bookMapper.findBooks(bookCustom));
    }

    // 动态sql查询总数测试
    @Test
    public void totalBooks() {

        System.out.println(bookMapper.totalBooks(null));
    }
}
