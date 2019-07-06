package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liukangwei
        * @date 2019/5/26   16:46
        */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(HttpServletRequest request,HttpServletResponse httpServletResponse){
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setPhoneNo(request.getParameter("phoneNo"));
       if(userService.LoginService(user).get("msg")=="登录成功"){
           httpServletResponse.setHeader("username","lkw");
           return "index";
       }
       else return "login";
    }

}
