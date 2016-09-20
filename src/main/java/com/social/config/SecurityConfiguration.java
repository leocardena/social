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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.csrf.CsrfFilter;
import com.social.filter.CsrfCookieGeneratorFilter;
import com.social.security.AjaxAuthenticationFailureHandler;
import com.social.security.AjaxAuthenticationSuccessHandler;
import com.social.security.AjaxLogoutSuccessHandler;
import com.social.security.Http401UnauthorizedEntryPoint;
import com.social.security.handler.CustomAccessDeniedHandler;
import com.social.security.util.AuthoritiesConstants;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	    @Inject
	    private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;

	    @Inject
	    private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;

	    @Inject
	    private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;

	    @Inject
	    private Http401UnauthorizedEntryPoint authenticationEntryPoint;

	    @Inject
	    private UserDetailsService userDetailsService;
	    
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
	            .csrf()
	        .and()
	            .addFilterAfter(new CsrfCookieGeneratorFilter(), CsrfFilter.class)
	            .exceptionHandling()
	            .accessDeniedHandler(new CustomAccessDeniedHandler())
	            .authenticationEntryPoint(authenticationEntryPoint)
	        .and()
	        	.rememberMe()
	        .and()
	            .formLogin()
	            .loginProcessingUrl("/api/authentication")
	            .successHandler(ajaxAuthenticationSuccessHandler)
	            .failureHandler(ajaxAuthenticationFailureHandler)
	            .usernameParameter("j_username")
	            .passwordParameter("j_password")
	            .permitAll()
	        .and()
	            .logout()
	            .logoutUrl("/api/logout")
	            .logoutSuccessHandler(ajaxLogoutSuccessHandler)
	            .deleteCookies("JSESSIONID", "CSRF-TOKEN")
	            .invalidateHttpSession(true)
	            .permitAll()
	        .and()
	            .headers()
	            .frameOptions()
	            .disable()
	        .and()
	            .authorizeRequests()
	            .antMatchers(HttpMethod.POST, "/api/rest/account").permitAll()
	            .antMatchers(HttpMethod.GET, "/api/rest/account/activate").permitAll()
	            .antMatchers(HttpMethod.GET, "/api/rest/trakt/movie/popular").permitAll()
	            .antMatchers(HttpMethod.GET, "/api/rest/trakt/show/popular").permitAll()
	            .antMatchers("/api/authenticate").permitAll()
	            .antMatchers("/api/rest/**").authenticated()
	            .antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN.toString())
	            .antMatchers("/v2/api-docs/**").permitAll()
	            .antMatchers("/h2-console/**").permitAll();

	    }

	    @Bean
	    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
	        return new SecurityEvaluationContextExtension();
	    }

}
