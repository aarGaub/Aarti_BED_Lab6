package com.debate.registration.students.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.debate.registration.students.service.MyUserDetailServiceImpl;

/* Beginning with version 5.7.0-M2, Spring deprecates the use of WebSecurityConfigureAdapter
 * and suggests creating configurations without it. Upgrading the deprecated WebSecurityConfigureAdapter
 * and instead using SecurityFilterChain.
 *  This Spring Boot project(3.1.4) uses Spring Security version 5.6.1 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
				.requestMatchers("/", "/registerStudents/saveStudentDetails", "/registerStudents/getStudentForm",
						"/registerStudents/403")
				.hasAnyAuthority("USER", "ADMIN")
				.requestMatchers("/registerStudents/edit/*", "/registerStudents/delete/*").hasAuthority("ADMIN")
				.anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
				.successForwardUrl("/registerStudents/listStudents").permitAll().and().logout()
				.logoutUrl("/registerStudents/logout").logoutSuccessUrl("/login").permitAll().and().exceptionHandling()
				.accessDeniedPage("/registerStudents/403").and().authenticationProvider(authenticationProvider()).cors()
				.and().csrf().disable();

		return http.build();
	}

}
