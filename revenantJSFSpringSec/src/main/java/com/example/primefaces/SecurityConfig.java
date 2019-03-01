package com.example.primefaces;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/javax.faces.resource/**").permitAll()
				.antMatchers("/adminPage/**").hasRole("ADMIN")
				.antMatchers("/**").hasAnyRole("ADMIN","USER")
				.and().formLogin().loginPage("/login.xhtml").permitAll().failureUrl("/login.xhtml?error=true")
				.and().logout().logoutSuccessUrl("/login.xhtml").permitAll()
				.and().exceptionHandling().accessDeniedPage("/accessDenied.jsp")
				.and().csrf().disable();
		
		http.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("john.doe").password("{noop}1234").roles("USER").and()
//				.withUser("jane.doe").password("{noop}5678").roles("ADMIN");
		auth.jdbcAuthentication()
				.usersByUsernameQuery("select username,password, enabled from public.user where username=?")
				.passwordEncoder(new BCryptPasswordEncoder())
				.authoritiesByUsernameQuery("select username,role from public.user_roles where username=?")
				.dataSource(dataSource);
	}

}
