package com.CodingNinjas.TaxEase.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.method.configuration.*;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TaxSecurityConfig {

    /*
        This is the security configuration class for the application, complete the class by doing the following:
        a. Use appropriate annotations.
        b. Create a securityFilterChain bean
        c. Create a passwordEncoder bean.
        d. Create a userDetailService bean in which create a user with normal role.
     */

	//problem 1 
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		http.csrf().disable()
//		.authorizeHttpRequests()
//		.antMatchers("/api/tax/**").hasRole("NORMAL")
//		.anyRequest()
//		.authenticated()
//		.and()
//		//.httpBasic();
//		.formLogin();
//	
//		return http.build();
//	}
//	//problem 2
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		http.csrf().disable()
//		.authorizeHttpRequests()
//		.antMatchers("/api/tax/approve/**").hasRole("ADMIN")
//		.antMatchers("/api/tax/reject/**").hasRole("ADMIN")
//		.antMatchers("/api/tax/**").hasRole("NORMAL")
//		.anyRequest()
//		.authenticated()
//		.and()
//		.httpBasic();
//		//.formLogin().permitAll();
//	
//		return http.build();
//	}

	//problem 3 reomve ant matchers
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			
			http.csrf().disable()
			.authorizeHttpRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
			//.formLogin().permitAll();
		
			return http.build();
		}
		
	@Bean
	public UserDetailsService user() {
		UserDetails user1 = User.builder()
				.username("john")
				.password(passwordEncoder().encode("john123"))
				.roles("NORMAL")
				.build();
		
		UserDetails user2 = User.builder()
				.username("steve")
				.password(passwordEncoder().encode("abc123"))
				.roles("ADMIN")
				.build();
		//return (UserDetailsService) user1;
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
}
