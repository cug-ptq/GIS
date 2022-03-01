package com.example.gis.service.impl;

import com.example.gis.dao.LoginDao;
import com.example.gis.entity.User;
import com.example.gis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public User getUserByPassWord(String password) {
        return loginDao.getUserByPassWord(password);
    }

    @Override
    public User getUserByEmail(String email) {
        return loginDao.getUserByEmail(email);
    }

    @Override
    public User getUserByEmail_PassWord(String email, String password) {
        return loginDao.getUserByEmail_PassWord(email,password);
    }

    @Override
    public void signUpUser(User user) {
        loginDao.signUpUser(user);
    }
}
