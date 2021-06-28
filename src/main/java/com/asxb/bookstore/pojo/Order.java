package com.asxb.bookstore.pojo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{

    private static final long serialVersionUID = 435841321473840065L;

    private Long orderId;
    private Long userId;
    private Date orderDatetime;
    private String consignee;
    private String phone;
    private String postalcode;
    private String address;
    private Integer sendType;
    private Date sendDatetime;
    private Float orderPrice;
    private Integer orderState;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Date getSendDatetime() {
        return sendDatetime;
    }

    public void setSendDatetime(Date sendDatetime) {
        this.sendDatetime = sendDatetime;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", orderDatetime=" + orderDatetime +
                ", consignee='" + consignee + '\'' +
                ", phone='" + phone + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", address='" + address + '\'' +
                ", sendType=" + sendType +
                ", sendDatetime=" + sendDatetime +
                ", orderPrice=" + orderPrice +
                ", orderState=" + orderState +
                '}';
    }
}
