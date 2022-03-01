package com.example.gis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    //首页
    @RequestMapping("/index")
    public String success(Model model){
        model.addAttribute("msg","asfs");
        return "index";
    }
}
