package com.asxb.bookstore;

import com.asxb.bookstore.mapper.BookMapper;
import com.asxb.bookstore.pojo.Book;
import com.asxb.bookstore.utils.PinYinUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

    @Test
    public void addBookTime() {
        List<Book> list = bookMapper.findAllBook();
        for (int i = 0; i < list.size(); i++) {
            Book book = list.get(i);
//            System.out.println(book.toString());

            Date date = book.getDeployDatetime();
            if(date == null) {
                book.setDeployDatetime(randomDate("2007-9-10","2021-6-28"));
                bookMapper.updateBookPinyin(book);
            }
            System.out.println(date);
        }
    }


    private static Date randomDate(String beginDate,String  endDate ){

        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date start = format.parse(beginDate);//构造开始日期

            Date end = format.parse(endDate);//构造结束日期

//getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。

            if(start.getTime() >= end.getTime()){

                return null;

            }

            long date = random(start.getTime(),end.getTime());

            return new Date(date);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return null;
    }

    private static long random(long begin,long end){

        long rtn = begin + (long)(Math.random() * (end - begin));

//如果返回的是开始时间和结束时间，则递归调用本函数查找随机值

        if(rtn == begin || rtn == end){

            return random(begin,end);

        }

        return rtn;

    }
    @Test
    public void addBookDes() {
        List<String> listDes = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("book_desc.csv"));
            String str;
            while ((str = in.readLine()) != null) {
                listDes.add(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Book> list = bookMapper.findAllBook();
        for (int i = 5; i < (Math.min(list.size(), listDes.size())); i++) {
            Book book = list.get(i);

           // System.out.println(book);

            book.setBookDesc(listDes.get(i - 5));
            System.out.println(book);
            bookMapper.updateBookPinyin(book);
        }
    }

    @Test
    public void addBookImage() {
        List<String> listImg = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("book_pic.csv"));
            String str;
            while ((str = in.readLine()) != null) {
                listImg.add(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




        List<Book> list = bookMapper.findAllBook();
        for (int i = 4; i < (Math.min(list.size(), listImg.size())); i++) {
            Book book = list.get(i);

//            System.out.println(book);

            book.setBookImage(listImg.get(i - 4));
            System.out.println(book);
            bookMapper.updateBookPinyin(book);
        }
    }



    @Test
    public void addPinYin_test() {
        List<Book> list = bookMapper.findAllBook();

        for (int i = 0; i < list.size(); i++) {
            Book book = list.get(i);
            System.out.println(book.toString());
            String name = book.getBookName();
            System.out.println(name);
            String py = PinYinUtil.toPinyin(name);
            book.setNamePinyin(py);
            System.out.println(py);

            int r = bookMapper.updateBookPinyin(book);
            if (r != 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("失败");
            }

        }
    }

}
