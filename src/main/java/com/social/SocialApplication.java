package com.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import com.social.config.SocialProperties;

@SpringBootApplication
@EnableConfigurationProperties({ SocialProperties.class})
public class SocialApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SocialApplication.class, args);
	}
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SocialApplication.class);
    }

	
}
