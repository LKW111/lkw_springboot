package com.example.demo.service;

import com.example.demo.MyUtils.MyUtils;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liukangwei
 * @date 2019/5/25   20:29
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    MailSender mailSender;

    public Map<String,Object> LoginService(User user){
        Map<String,Object> map=new HashMap<>();
        if(MyUtils.md5(user.getPassword()).equals(userDao.SelectByname(user.getUsername()).getPassword())){
            map.put("msg","登录成功");
        }
        else{
            map.put("msg","登录失败");
        }
        return map;
    }
    public Map<String,Object> RegisterService(User registerUser){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isEmpty(registerUser.getUsername())){
            map.put("msg","用户名不能为空");
            map.put("code","A0001");
            return map;
        }
        if(StringUtils.isEmpty(registerUser.getPassword())){
            map.put("msg","密码不能为空");
            map.put("code","A0002");
            return map;
        }
        User user=userDao.SelectByname(registerUser.getUsername());
        if(user!=null){
            map.put("msg","用户名已存在");
            map.put("code","A0003");
            return map;
        }
        try{
        registerUser.setPassword(MyUtils.md5(registerUser.getPassword()));
        userDao.AddUser(registerUser);
        }catch (Exception e){
            map.put("msg","注册异常");
            map.put("code","A0004");
        }
        map.put("msg","注册成功");
        map.put("code","A0000");
        mailSender.sendMail(registerUser.getEmail(),
                            "注册成功通知",
                            "恭喜，您已成为本网站用户，点击下面链接激活账户");
        return map;
    }
}
