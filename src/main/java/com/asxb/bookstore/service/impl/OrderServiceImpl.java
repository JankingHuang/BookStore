package com.asxb.bookstore.service.impl;

import com.asxb.bookstore.mapper.OrderMapper;
import com.asxb.bookstore.pojo.Order;
import com.asxb.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    @Override
    public List<Order> findOrderByUserAndType(BigDecimal userId, Integer type, Integer pageNum, Integer size) {
        return orderMapper.findOrderByUserAndType(userId, type, pageNum, size);
    }

    @Override
    public BigDecimal totalOrderByUserAndType(BigDecimal userId, Integer type) {
        return orderMapper.totalOrderByUserAndType(userId, type);
    }

    @Override
    public void updateType(BigDecimal orderId, Integer type) {
        orderMapper.updateType(orderId, type);
    }
}
