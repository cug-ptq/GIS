package com.example.gis.controller;

import com.example.gis.assist.Msg;
import com.example.gis.entity.User;
import com.example.gis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value = "/login/auth",method = RequestMethod.POST)
    @ResponseBody
    public Msg authLogin(Model model, String LoginEmail,
                         String LoginPassword, HttpServletRequest request){
        System.out.println(LoginEmail);
        if(LoginEmail!=null&&LoginPassword!=null){
            if(LoginEmail.length()!=0&&LoginPassword.length()!=0){
                if(loginService.getUserByEmail_PassWord(LoginEmail,LoginPassword)!=null){
                    System.out.println(LoginEmail);
                    //用户放入session
                    request.getSession().setAttribute("user",
                            loginService.getUserByEmail_PassWord(LoginEmail,LoginPassword));
                    return Msg.success();
                }
            }
        }
        return Msg.error().add("error","邮箱或密码错误");
    }

    @RequestMapping(value = "/login/signUp", method = RequestMethod.POST)
    @ResponseBody
    public Msg authSignUp(Model model,String signUpUsername,
                          String signUpPassword,
                          String signUpEmail,
                          String signUpTel,
                          int signUpAge){
        if(signUpEmail!=null&&signUpUsername!=null&signUpPassword!=null){
            if(signUpEmail.length()!=0&&signUpUsername.length()!=0&signUpPassword.length()!=0){
                if(loginService.getUserByPassWord(signUpPassword)==null){
                    loginService.signUpUser(new User(signUpUsername,signUpEmail,
                            signUpPassword,signUpTel,signUpAge));
                    return Msg.success();
                }
            }
        }
        return Msg.error().add("error","您已经注册过");
    }
}
