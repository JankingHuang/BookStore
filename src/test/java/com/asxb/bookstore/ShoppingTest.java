package com.asxb.bookstore;

import com.asxb.bookstore.mapper.ItemMapper;
import com.asxb.bookstore.pojo.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * 与购物车相关的mapper测试
 *
 * @author 刘斌
 * @date 2021/6/29 16:59
 */
@SpringBootTest
class ShoppingTest {

    @Autowired
    ItemMapper itemMapper;

    @Test
    void find_test1() {
        // 购物车初始化查询
        System.out.println(itemMapper.findItemByUserId(new BigDecimal(1)));
    }

    @Test
    void find_test2() {
        // 加入购物车前判断是否存在。存在则数量加一
        System.out.println(itemMapper.findItemIdByUserAndBookId(1L, 3L));
    }

    @Test
    void delete_test1() {
        // 删除指定item
        itemMapper.deleteByItemId(new BigDecimal(1));
    }

    @Test
    void delete_test2() {
        // 清空购物车
        itemMapper.deleteByUserId(new BigDecimal(1));
    }

    @Test
    void update_test1() {
        // 指定数值修改数量
        itemMapper.changeQuantity(new BigDecimal(2), 3);
    }

    @Test
    void update_test2() {
        // 数量在原基础上+1
        itemMapper.updateQuantity(new BigDecimal(2));
    }

    @Test
    void insert_test1() {
        Item item = new Item();
        item.setUserId(1L);
        item.setBookId(5L);

        itemMapper.insertItem(item);
    }

}
