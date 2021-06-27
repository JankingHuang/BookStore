package com.asxb.bookstore.pojo;

import java.io.Serializable;

public class Item implements Serializable{

    private static final long serialVersionUID = 435841321473840065L;

    private Long oderItemId;
    private Long orderId;
    private Long bookId;
    private Integer quantity;

    public Long getOderItemId() {
        return oderItemId;
    }

    public void setOderItemId(Long oderItemId) {
        this.oderItemId = oderItemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
                ", orderId=" + orderId +
                ", bookId=" + bookId +
                ", quantity=" + quantity +
                '}';
    }
}
