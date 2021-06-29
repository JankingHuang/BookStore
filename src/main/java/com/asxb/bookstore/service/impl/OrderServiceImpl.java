package com.asxb.bookstore.service.impl;

import com.asxb.bookstore.mapper.OrderMapper;
import com.asxb.bookstore.pojo.Order;
import com.asxb.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘斌
 * @date 2021/6/29 21:09
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }
}
