package com.asxb.bookstore.service.impl;

import com.asxb.bookstore.mapper.RegisterMapper;
import com.asxb.bookstore.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterMapper registerMapper;


    @Override
    public String verrifyDupulicate(String userName) {
        // 查询名字是否已存在
        return registerMapper.checkNameDuplicate(userName);
    }

    // 插入数据
    @Override
    public void insertService(String userName, String password) {
        registerMapper.register(userName, password);
    }
}
