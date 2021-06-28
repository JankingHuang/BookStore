package com.asxb.bookstore.service.impl;

import com.asxb.bookstore.mapper.LoginMapper;
import com.asxb.bookstore.pojo.User;
import com.asxb.bookstore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public User loginSelect(String userName, String password) {
        return loginMapper.loginSelect(userName, password);
    }
}
