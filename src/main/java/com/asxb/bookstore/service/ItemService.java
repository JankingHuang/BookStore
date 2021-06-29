package com.asxb.bookstore.service;

import com.asxb.bookstore.pojo.Item;

import java.math.BigDecimal;
import java.util.List;

public interface ItemService {

    List<Item> findItemByUserId(BigDecimal id);

    void deleteItemById(BigDecimal id);

    void changeItemQuantity(BigDecimal id, Integer amount);

    void clearShoppingCar(BigDecimal id);

    void addQuantity(BigDecimal id);

    BigDecimal findItemId(Long userId, Long bookId);

    void insertItem(Item item);

}
