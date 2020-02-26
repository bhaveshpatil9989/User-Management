package com.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
//@EnableWebMvc
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	 @Override
	    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {	 
		  auth.authenticationProvider(authenticationProvider());
	 }
	 
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		 
		http
		.csrf()
		.disable()
        .authorizeRequests()
        .antMatchers(
        	"/role/**",	
        	"/role/addRole/**",	
        	"/permission/**",
            "/registration**",
            "/js/**",
            "/css/**",
            "/img/**",
            "/webjars/**",
            "/chosen/**",
            "/jtable/**",
            "/addUser.htm**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/perform_login")
        .defaultSuccessUrl("/dashboard.html",true)
        .failureUrl("/login?error=true")
        .permitAll()
        .and()
        .logout()
        .invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login?logout")
        .permitAll();
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	        auth.setUserDetailsService(userDetailsService);
	        auth.setPasswordEncoder(passwordEncoder());
	        return auth;
	    }

}
