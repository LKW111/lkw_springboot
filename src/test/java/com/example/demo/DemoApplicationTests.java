package com.example.demo;

import com.example.demo.MyUtils.MyUtils;
import com.example.demo.dao.UserDao;
import com.example.demo.service.MailSender;
import com.example.demo.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	UserDao userDao;
	@Autowired
	MailSender mailSender;
	@Test
	public void testMapper() {
		System.out.println(MyUtils.md5("12345678"));
		System.out.println();
		mailSender.sendMail("1984402393@qq.com","测试邮件","测试spring邮件发送功能");
	}
	/*@Test
	public void sendSimpleMail() throws MailException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("1984402393@qq.com"); // 邮件发送者
		message.setTo("1984402393@qq.com"); // 邮件接受者
		message.setSubject("subject"); // 主题
		message.setText("测试邮件"); // 内容
		javaMailSender.send(message);
	}*/
}
