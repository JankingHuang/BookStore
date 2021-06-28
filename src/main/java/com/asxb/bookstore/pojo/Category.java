package com.asxb.bookstore.pojo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author 刘斌
 * @date 2021/6/27 16:06
 */
public class Category implements Serializable {
    private static final long serialVersionUID = -8362231900993812313L;
    private Long id;
    private String categoryName;

    public Category() {
    }

    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
