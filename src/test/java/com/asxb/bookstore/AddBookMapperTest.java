package com.asxb.bookstore;

import com.asxb.bookstore.mapper.BookMapper;
import com.asxb.bookstore.pojo.Book;
import com.asxb.bookstore.utils.PinYinUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author 刘斌
 * @date 2021/6/28 9:17
 */
@SpringBootTest
public class AddBookMapperTest {


    @Autowired
    BookMapper bookMapper;

    @Test
    public void add_test() {

        Book book = new Book();
        book.setBookName("Java从跨平台到跨行业");
        book.setBookAuthor("佚名");
        book.setNamePinyin(PinYinUtil.toPinyin(book.getBookName()));
        book.setBookPrice(23.3f);
        book.setPublishing("新华出版社");
        book.setBookDesc("Java劝退书经典著作");
        book.setCategoryId(4L);
        book.setDeployDatetime(new Date());

        bookMapper.addBook(book);
    }

}
