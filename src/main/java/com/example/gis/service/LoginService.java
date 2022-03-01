package com.example.gis.service;

import com.example.gis.entity.User;

public interface LoginService {
    User getUserByPassWord(String password);
    User getUserByEmail(String email);
    User getUserByEmail_PassWord(String email,String password);

    void signUpUser(User user);
}
