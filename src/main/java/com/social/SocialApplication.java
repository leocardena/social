package com.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.social.config.SocialProperties;

@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties({ SocialProperties.class})
public class SocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialApplication.class, args);
	}
	
}
