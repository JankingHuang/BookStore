package com.asxb.bookstore.mapper;


import com.asxb.bookstore.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {

    User loginSelect(@Param("name") String name, @Param("password") String password);
}
