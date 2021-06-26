package com.asxb.bookstore.pojo;

import java.io.Serializable;
import java.math.BigInteger;

public class User implements Serializable {

    private static final long serialVersionUID = -8362231900993817093L;

    private BigInteger userId;
    private String userName;
    private String password;
    private int type;

    public User() {
    }

    public User(BigInteger userId, String userName, String password, int type) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
