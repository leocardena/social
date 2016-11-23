package com.social.config;

import javax.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import com.social.security.Http401UnauthorizedEntryPoint;
import com.social.security.jwt.JWTConfigurer;
import com.social.security.jwt.TokenProvider;
import com.social.security.util.AuthoritiesConstants;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	    @Inject
	    private Http401UnauthorizedEntryPoint authenticationEntryPoint;

	    @Inject
	    private UserDetailsService userDetailsService;
	    
	    @Inject
	    private TokenProvider tokenProvider;
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Inject
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	            .userDetailsService(userDetailsService)
	                .passwordEncoder(passwordEncoder());
	    }

	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring()
	            .antMatchers(HttpMethod.OPTIONS, "/**")
	            .antMatchers("/app/**/*.{js,html}")
	            .antMatchers("/bower_components/**")
	            .antMatchers("/i18n/**")
	            .antMatchers("/content/**")
	            .antMatchers("/test/**");
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	
	        http
            .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint)
        .and()
            .csrf()
            .disable()
            .headers()
            .frameOptions()
            .disable()
        .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/rest/account/register").permitAll()
            .antMatchers(HttpMethod.GET, "/api/rest/account/activate").permitAll()
            .antMatchers(HttpMethod.GET, "/api/rest/trakt/movie/popular").permitAll()
            .antMatchers(HttpMethod.GET, "/api/rest/trakt/show/popular").permitAll()
            .antMatchers(HttpMethod.GET, "/api/rest/trakt/search/{\\d+}").permitAll()
            .antMatchers(HttpMethod.GET, "/api/rest/tmdb/movie/popular").permitAll()
            .antMatchers("/api/authenticate").permitAll()
            .antMatchers("/api/rest/account/reset_password/init").permitAll()
            .antMatchers("/api/rest/account/reset_password/finish").permitAll()
            .antMatchers("/api/rest/**").authenticated()
            .antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN.toString())
            .antMatchers("/v2/api-docs/**").permitAll()
        .and()
            .apply(securityConfigurerAdapter());

	    }
	    
	    private JWTConfigurer securityConfigurerAdapter() {
	        return new JWTConfigurer(tokenProvider);
	    }

	    @Bean
	    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
	        return new SecurityEvaluationContextExtension();
	    }

}
