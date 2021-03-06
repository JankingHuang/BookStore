package com.asxb.bookstore;

import com.asxb.bookstore.common.BookCustom;
import com.asxb.bookstore.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

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
    public void findBooksTest_1() {

        BookCustom bookCustom = new BookCustom();
//        bookCustom.setSortField("");
//        bookCustom.setCategoryId(11L);

        bookCustom.setBookState(1);
        System.out.println(bookMapper.findBooks(bookCustom));
    }

    // 动态sql查询新上架/热销书籍测试
    @Test
    public void findBooksTest_2() {

        BookCustom bookCustom = new BookCustom();
        bookCustom.setBookState(2);
//        bookCustom.setSortField("deploy_datetime");
        bookCustom.setSortField("sales_volume");
        bookCustom.setSortType("DESC");
        bookCustom.setPageNum(0);
        bookCustom.setSize(5);
//        bookCustom.setCategoryId(11L);

        System.out.println(bookMapper.findBooks(bookCustom));
    }

    // 动态sql查询总数测试
    @Test
    public void totalBooks() {

        System.out.println(bookMapper.totalBooks(null));
    }

    // 书籍下架/上架测试
    @Test
    public void changeBookStateTest() {
        // success - 上架
       bookMapper.bookUp(new BigDecimal(1));
        // success - 下架
        bookMapper.bookDown(new BigDecimal(2));
    }

    @Test
    public void deleteTest(){

        bookMapper.deleteBookById(new BigDecimal(7));
    }

    @Test
    public void findBookByIdTest() {

        System.out.println(bookMapper.findBookById(new BigDecimal(1)));
    }

}
