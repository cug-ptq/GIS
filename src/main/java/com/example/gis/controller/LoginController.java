package com.example.gis.controller;

import com.example.gis.assist.Msg;
import com.example.gis.entity.User;
import com.example.gis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping("/login/auth")
    @ResponseBody
    public Msg authLogin(Model model, String LoginEmail, String LoginPassword){
        System.out.println(LoginEmail);
        if(LoginEmail!=null&&LoginPassword!=null){
            if(LoginEmail.length()!=0&&LoginPassword.length()!=0){
                if(loginService.getUserByEmail_PassWord(LoginEmail,LoginPassword)!=null){
                    System.out.println(LoginEmail);
                    return Msg.success();
                }
            }
        }
        return Msg.error().add("error","邮箱或密码错误");
    }

    @RequestMapping("/login/signUp")
    @ResponseBody
    public Msg authSignUp(Model model,String signUpUsername,
                             String signUpPassword,
                             String signUpEmail){
        if(signUpEmail!=null&&signUpUsername!=null&signUpPassword!=null){
            if(signUpEmail.length()!=0&&signUpUsername.length()!=0&signUpPassword.length()!=0){
                if(loginService.getUserByPassWord(signUpPassword)==null){
                    loginService.signUpUser(new User(signUpUsername,signUpEmail,signUpPassword));
                    return Msg.success();
                }
            }
        }
        return Msg.error().add("error","您已经注册过");
    }
}
