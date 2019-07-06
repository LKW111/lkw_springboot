package com.example.demo.controller;

import com.example.demo.MyUtils.MyUtils;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.spi.RegisterableService;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author liukangwei
 * @date 2019/5/26   18:59
 */
@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/registerdo")
    @ResponseBody
    public String registerDo(HttpServletRequest request){
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setPhoneNo(request.getParameter("phoneNo"));
        user.setEmail(request.getParameter("email"));
        Map<String,Object> map=userService.RegisterService(user);
        return MyUtils.getJSONStirng(map);
    }

}
