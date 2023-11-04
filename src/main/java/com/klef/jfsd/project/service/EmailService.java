package com.klef.jfsd.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService 
{
	@Autowired
private JavaMailSender javaMailSender;

@Async
public void sendEmail(String toEmail,String subject,String msgs)
{
	SimpleMailMessage mailMessage=new SimpleMailMessage();
	mailMessage.setTo(toEmail);
	mailMessage.setText(msgs);
	mailMessage.setSubject(subject);
	mailMessage.setFrom("taskmanagement679@gmail.com");
	javaMailSender.send(mailMessage);
}
}
