package com.prj.cosm;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CustomLoginSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new WebAccessDenyHandler();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				.antMatchers("/top", "/login", "/joinForm", "/empCheckId", "/empInsert", "/userSelect","/planUpdate").permitAll()
				.antMatchers("/*").hasAuthority("ROLE_D0101").anyRequest().authenticated()).formLogin()
				.loginPage("/login").usernameParameter("userId").loginProcessingUrl("/login")
				.successHandler(successHandler()).and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
				.invalidateHttpSession(true).deleteCookies("JSESSIONID").and().exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler()).and()
		// .csrf().disable()
		// .userDetailsService(userService());
		;

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		String loginSql = "select USERS_ID, USERS_PASSWORD, 1 from USERS where USERS_ID = ?";
		String authSql = "select users_id, 'ROLE_'||users_author FROM users where users.users_id = ?";
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(loginSql)
				.authoritiesByUsernameQuery(authSql)
		// .passwordEncoder(passwordEncoder())
		;
	}

}
