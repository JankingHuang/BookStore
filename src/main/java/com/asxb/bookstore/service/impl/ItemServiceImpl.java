package com.asxb.bookstore.service.impl;

import com.asxb.bookstore.mapper.ItemMapper;
import com.asxb.bookstore.pojo.Item;
import com.asxb.bookstore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 刘斌
 * @date 2021/6/29 17:03
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<Item> findItemByUserId(BigDecimal id) {
        return itemMapper.findItemByUserId(id);
    }

    @Override
    public void deleteItemById(BigDecimal id) {
        itemMapper.deleteByItemId(id);
    }

    @Override
    public void changeItemQuantity(BigDecimal id, Integer amount) {
        itemMapper.changeQuantity(id, amount);
    }

    @Override
    public void clearShoppingCar(BigDecimal id) {
        itemMapper.deleteByUserId(id);
    }

    @Override
    public void addQuantity(BigDecimal id) {
        itemMapper.updateQuantity(id);
    }

    @Override
    public BigDecimal findItemId(Long userId, Long bookId) {
        return itemMapper.findItemIdByUserAndBookId(userId, bookId);
    }

    @Override
    public void insertItem(Item item) {
        itemMapper.insertItem(item);
    }
}
