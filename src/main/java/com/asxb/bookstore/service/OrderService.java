package com.asxb.bookstore.service;

import com.asxb.bookstore.pojo.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    void insertOrder(Order order);

    List<Order> findOrderByUserAndType(BigDecimal userId, Integer type,  Integer pageNum, Integer size);

    BigDecimal totalOrderByUserAndType(BigDecimal userId, Integer type);

    void updateType(BigDecimal orderId, Integer type);
}
