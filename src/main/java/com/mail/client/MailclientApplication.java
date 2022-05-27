package com.mail.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailclientApplication {

	public void sendEmail(JavaMailSender javamailSender, String recipient, String content, String subject) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("sebastian@lapke.info");
		msg.setTo(recipient);

		msg.setSubject(subject);
		msg.setText(content);
		javamailSender.send(msg);
	}
}
