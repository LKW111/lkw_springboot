package com.example.demo.service;

import com.example.demo.pojo.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Map;
import java.util.Properties;

/**
 * @author liukangwei
 * @date 2019/6/22   16:49
 */
@Service
public class MailSender implements InitializingBean {
    private JavaMailSenderImpl javaMailSender;

    public boolean sendMail(String to, String subject,String text){
        try {
            String nick = MimeUtility.encodeText("测试用户昵称");
            InternetAddress from = new InternetAddress(nick+"<liukangwei_wy@163.com>");
            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text);
            javaMailSender.send(mimeMessage);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public void afterPropertiesSet(){
        javaMailSender= new JavaMailSenderImpl();
        javaMailSender.setUsername("liukangwei_wy@163.com");
        javaMailSender.setPassword("lkw134916");
        javaMailSender.setHost("smtp.163.com");
        javaMailSender.setPort(465);
        javaMailSender.setProtocol("smtps");
        javaMailSender.setDefaultEncoding("utf8");
        Properties javaMailProperties=new Properties();
        javaMailProperties.put("mail.stmp.ssl.enable",true);
        javaMailSender.setJavaMailProperties(javaMailProperties);

    }
}
