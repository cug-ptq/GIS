package com.example.gis.controller;

import com.example.gis.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class IndexController {
    //首页
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        System.out.println(user.getEmail());
        model.addAttribute("name","ptq");
        return "index";
    }

    @RequestMapping("/getName")
    @ResponseBody
    public String getName(Model model, String lat,String lon){
        System.out.println(lat);
        return "name";
    }
//    @RequestMapping("/upload")
//    public void upload(Model model){
//
//    }
//    @RequestMapping("demo")
//    public String demo(HttpServletRequest request){
//        User user = (User) request.getSession().getAttribute("user");
//        System.out.println(user.getEmail());
//        return "demo4";
//    }
}
