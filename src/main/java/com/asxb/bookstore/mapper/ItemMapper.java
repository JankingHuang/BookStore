package com.asxb.bookstore.mapper;

import com.asxb.bookstore.pojo.Item;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface ItemMapper {

    // 查询未结算的订单 - 初始化购物车
    List<Item> findItemByUserId(BigDecimal id);

    @Delete("delete from t_order_item where order_item_id = #{id}")
    void deleteByItemId(BigDecimal id);

    @Delete("delete from t_order_item where user_id = #{id} and state = 1")
    void deleteByUserId(BigDecimal id);

    @Update("update t_order_item set quantity = #{amount} where order_item_id = #{id}")
    void changeQuantity(BigDecimal id, Integer amount);

    @Update("update t_order_item set quantity = quantity + 1 where order_item_id = #{id}")
    void updateQuantity(BigDecimal id);

    @Select("select order_item_id from t_order_item where user_id = #{userId} and book_id = #{bookId} and state = 1")
    BigDecimal findItemIdByUserAndBookId(@Param("userId") Long userId, @Param("bookId") Long bookId);

    void insertItem(Item item);
}
