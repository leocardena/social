package com.social.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {

	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		
		javaMailSender.setProtocol("smtp");
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		//Set gmail email id
		javaMailSender.setUsername("social.moviesandshows@gmail.com");
		//Set gmail email password
		javaMailSender.setPassword("");
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.debug", "true");
		
		javaMailSender.setJavaMailProperties(prop);
		return javaMailSender;
	}

}
