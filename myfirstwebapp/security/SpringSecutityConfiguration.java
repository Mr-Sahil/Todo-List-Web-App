package com.sahil.springboot.myfirstwebapp.security ;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringSecutityConfiguration {


//	whenever we want to store username and password we use LDAP or Database
//	In Memory makes things simple
	
//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails... users)
//	User is a class, it is a builder we can use it to build password

	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		UserDetails userDetails1 = createNewUser("Sahil Soni", "1234");
//		UserDetails userDetails2 = createNewUser("Arshiya Mansoori", "1234");
//		UserDetails userDetails3 = createNewUser("Pranjal Rathore", "1234");
		
		return new InMemoryUserDetailsManager(userDetails1);
	}

	private UserDetails createNewUser(String username, String password) {
		
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);		
		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password).roles("USER", "ADMIN").build();
		
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	Due to Spring Security our all URLs are protected
//	A login form is shown for unauthorized requests
//	Now due this we are not even able to access the H2 Console so for that we have to disable something called CSRF
//	CSRF :-  Cross Site Request Forgery ( In an application where end users can log in, it is important to consider 
//											how to protect against Cross Site Request Forgery (CSRF). 
//											Spring Security protects against CSRF attacks by default for unsafe HTTP methods,
//											such as a POST request, so no additional code is necessary. )

//	H2 also make use of something called Frames and Spring Security does not allow Frames by default 
//	so we also need to make sure that frames are also allowed.
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
	
	//but ultimately we don't need it in Spring Boot 6
	

}

