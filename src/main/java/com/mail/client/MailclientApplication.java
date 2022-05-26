package com.mail.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
@SpringBootApplication
public class MailclientApplication implements CommandLineRunner {
	@Autowired
	private JavaMailSender javaMailSender;
	public static void main(String[] args) {
		SpringApplication.run(MailclientApplication.class, args);

	}
	@Override
	public void run(String... args) {

		System.out.println("Sending Email...");

		sendEmail();

		System.out.println("Done");

	}

	public void sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("sebastian@lapke.info");
		msg.setTo("sebastian_lapke@icloud.com");

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");
		javaMailSender.send(msg);
	}
}
