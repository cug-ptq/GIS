package com.example.gis.dao;

import com.example.gis.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    User getUserByPassWord(String password);
    User getUserByEmail(String email);
    User getUserByEmail_PassWord(String email,String password);
    void signUpUser(User user);
}
