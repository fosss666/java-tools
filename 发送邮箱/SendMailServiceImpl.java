package com.fosss.easypan.service.impl;

import com.fosss.easypan.service.SendMailService;
import com.fosss.reggie.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {
    //发件人
    private String from="1745179058@qq.com";
    //主题
    private String subject = "验证码";

    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendMail(String to,String code) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from+"(FOSSS)");//括号必须是英文状态下的
        message.setTo(to);
        message.setSubject(subject);
        message.setText(code);
        javaMailSender.send(message);
    }
}
