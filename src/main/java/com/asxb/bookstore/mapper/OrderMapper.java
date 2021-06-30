package com.asxb.bookstore.mapper;

import com.asxb.bookstore.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    void insertOrder(Order order);

    List<Order> findOrderByUserAndType(BigDecimal userId, Integer type, Integer pageNum, Integer size);

    BigDecimal totalOrderByUserAndType(BigDecimal userId, Integer type);

    void updateType(BigDecimal orderId, Integer type);
}
