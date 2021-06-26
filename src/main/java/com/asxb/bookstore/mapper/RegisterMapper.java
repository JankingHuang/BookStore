package com.asxb.bookstore.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegisterMapper {

    @Insert("insert into t_user (user_name, password) VALUES (#{name}, #{password})")
    boolean register(@Param("name")String name, String password);

    @Select("select user_name as name from t_user where user_name = #{name}")
    String checkNameDuplicate(@Param("name") String name);
}
