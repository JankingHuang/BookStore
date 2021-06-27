package com.asxb.bookstore.service;

import com.asxb.bookstore.pojo.User;

public interface LoginService {

    User loginSelect(String userName, String password);
}
