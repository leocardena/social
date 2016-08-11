package com.social.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		String[] publics = { "/index", "/app/**", "/bower_components/**", "/h2-console/**" };
		
		http
		.authorizeRequests()
		.antMatchers(publics).permitAll()
		.and()
        .authorizeRequests()
        .antMatchers("/login*").anonymous()
            .anyRequest().authenticated()
        .and()
        .formLogin()
          //.loginPage("/login")
          .defaultSuccessUrl("/welcome")
          .loginProcessingUrl("/perform_login")
          .failureUrl("/login.html?error=true")
        .and()
        .logout().logoutSuccessUrl("/login.html");
		
//		http
//        .authorizeRequests()
//            .antMatchers("/login*").anonymous()
//            .anyRequest().authenticated()
//        .and()
//        .formLogin()
//          .loginPage("/login")
//          .defaultSuccessUrl("/homepage")
//          .failureUrl("/login.html?error=true")
//        .and()
//        .logout().logoutSuccessUrl("/login.html");
//		
//
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.
			inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ADMIN")
			.and()
			.withUser("user").password("user").roles("USER");
	}

}
