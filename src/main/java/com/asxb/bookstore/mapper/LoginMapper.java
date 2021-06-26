package com.asxb.bookstore.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Mapper
@Repository
public interface LoginMapper {

//    @Select("select user_id from t_user where user_name = #{name} and password = #{password}")
    BigInteger loginSelect(@Param("name") String name, @Param("password") String password);
}
