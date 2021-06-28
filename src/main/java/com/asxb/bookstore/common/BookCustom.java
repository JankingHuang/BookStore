package com.asxb.bookstore.common;

import com.asxb.bookstore.pojo.Book;

public class BookCustom extends Book {

    private static final long serialVersionUID = -9185948349227779417L;

    private String sortField;
    private String sortType;
    private String searchText;
    private Integer pageNum; // 页码
    private Integer size;   // 限制数量

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
