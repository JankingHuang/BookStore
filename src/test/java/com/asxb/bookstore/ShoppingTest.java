package com.asxb.bookstore;

import com.asxb.bookstore.mapper.ItemMapper;
import com.asxb.bookstore.mapper.OrderMapper;
import com.asxb.bookstore.pojo.Item;
import com.asxb.bookstore.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

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

    @Autowired
    OrderMapper orderMapper;

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
    void update_test3() {
        // 按user_id 修改state
        itemMapper.updateStateByUserId(new BigDecimal(1));
    }

    @Test
    void insert_test1() {
        // 插入一条 item 记录
        Item item = new Item();
        item.setUserId(1L);
        item.setBookId(5L);

        itemMapper.insertItem(item);
    }

    @Test
    void insert_test2(){
        // 插入一条order记录
        Order order = new Order();
        order.setUserId(1L);
        order.setOrderDatetime(new Date());
        order.setConsignee("AAA");
        order.setPhone("131********");
        order.setPostalcode("400");
        order.setAddress("testAddress");
        order.setSendType(2);
        order.setOrderPrice(99.9f);

        orderMapper.insertOrder(order);
    }

}
