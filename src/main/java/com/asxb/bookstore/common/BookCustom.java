package com.asxb.bookstore.common;

import com.asxb.bookstore.pojo.Book;

public class BookCustom extends Book {

    private static final long serialVersionUID = -9185948349227779417L;

    private String sortField;
    private String sortType;
    private String searchText;

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


}
