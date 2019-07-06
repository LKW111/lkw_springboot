package com.example.demo.controller;

import com.example.demo.MyUtils.MyUtils;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liukangwei
 * @date 2019/5/25   20:21
 */
@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String home(HttpServletRequest request){

        return "test";
    }
    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        Enumeration<String> headerNames=request.getHeaderNames();
        Collection<String> headerNamesr=response.getHeaderNames();
        session=request.getSession();
        Enumeration<String> attributeName=session.getAttributeNames();
        StringBuilder sb=new StringBuilder();
        while(attributeName.hasMoreElements()){
            String name=attributeName.nextElement();
            sb.append(name+"<br>");
        }
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
       return UUID.randomUUID().toString().replaceAll("-","");
    }


}
