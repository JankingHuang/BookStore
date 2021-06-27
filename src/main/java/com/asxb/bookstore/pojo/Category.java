package com.asxb.bookstore.pojo;

import java.math.BigInteger;

/**
 * @author 刘斌
 * @date 2021/6/27 16:06
 */
public class Category {

    private BigInteger id;
    private String categoryName;

    public Category() {
    }

    public Category(BigInteger id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
