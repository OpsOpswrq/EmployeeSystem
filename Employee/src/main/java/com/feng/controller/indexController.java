package com.feng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class indexController {
    @GetMapping("/toLogin")
    public String toLogin(){
        return "index";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        if("feng".equals(username)&&"123456".equals(password)){
            session.setAttribute("loginSession",username);
            return "redirect:main.html";
        }else{
            model.addAttribute("msg","密码或用户名出现错误");
        }
        return "index";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginSession");
        return "index";
    }
}
