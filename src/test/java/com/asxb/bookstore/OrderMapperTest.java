package com.asxb.bookstore;

import com.asxb.bookstore.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author 刘斌
 * @date 2021/6/30 8:24
 */
@SpringBootTest
class OrderMapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    void findOrder_Test() {
        System.out.println(orderMapper.findOrderByUserAndType(null, 1, 0, 5));
        System.out.println(orderMapper.totalOrderByUserAndType(null, 1));
    }

    @Test
    void updateType_Test() {
        orderMapper.updateType(new BigDecimal(1625012023607L), 4);
    }
}
