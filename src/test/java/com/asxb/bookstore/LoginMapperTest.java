package com.asxb.bookstore;

import com.asxb.bookstore.mapper.LoginMapper;
import com.asxb.bookstore.mapper.RegisterMapper;
import com.asxb.bookstore.utils.MD5;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/***
 * 单元测试 - 登录功能单元测试
 * @author 刘斌
 * @date 2021/6/25
 */
@SpringBootTest
public class LoginMapperTest {

    @Autowired
    LoginMapper loginMapper;

    @Test
    public void loginTest() {
        // 查询测试成功
        System.out.println(loginMapper.loginSelect("test1", new MD5().getMD5ofStr("123456")));
    }
}
