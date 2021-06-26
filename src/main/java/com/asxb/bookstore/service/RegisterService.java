package com.asxb.bookstore.service;

import com.asxb.bookstore.common.ResultInfo;

public interface RegisterService {

    // 查询用户名是否已经存在
    String verrifyDupulicate(String userName);

    // 插入数据
    void insertService(String userName, String password);
}
