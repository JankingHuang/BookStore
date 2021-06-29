package com.asxb.bookstore.pojo;

import java.io.Serializable;

public class Item implements Serializable {

    private static final long serialVersionUID = 435841321473840065L;

    private Long oderItemId;
    private Long userId; // 用户id
    private Long bookId;  // 书籍id
    private Integer quantity; // 书本数量
    private int state; // 结算状态 1-未结算，2-已结算
    private String bookName;
    private float price;
    private float totalPrice;

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getOderItemId() {
        return oderItemId;
    }

    public void setOderItemId(Long oderItemId) {
        this.oderItemId = oderItemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "oderItemId=" + oderItemId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                ", state=" + state +
                '}';
    }
}
