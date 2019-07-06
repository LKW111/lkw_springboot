package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * @author liukangwei
 * @date 2019/5/25   20:32
 */
@Mapper
public interface UserDao {
    //@Select({"select * from users where username=#{name}"})
    User SelectByname(String name);
    //@Insert({"insert into users(username,password,phoneNo,email) value(#{username},#{password},#{phoneNo},#{email})"})
    int AddUser(User user);

}
