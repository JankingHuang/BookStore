package com.asxb.bookstore;

import com.asxb.bookstore.mapper.RegisterMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/***
 * 单元测试 - 注册功能单元测试
 * @author 刘斌
 * @date 2021/6/25
 */
@SpringBootTest
public class RegisterMapperTest {

    @Autowired
    RegisterMapper registerMapper;

    @Test
    public void insertTest() {
        // 插入测试成功
        System.out.println(registerMapper.register("test1", "123456"));
    }

    @Test
    public void selectTest() {
        // 不存在的名字返回 null
        System.out.println(registerMapper.checkNameDuplicate("test11"));
        // 存在的返回名字值
        System.out.println(registerMapper.checkNameDuplicate("test1"));
    }
}
