package com.retroHIFI.webshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.retroHIFI.webshop.config.LoginSucessHandler;
import com.retroHIFI.webshop.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpingBootSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailServiceImpl;

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**",
			"/assets/**", "/vendor/**", "/images/**","/error/**","/static/**" };

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailServiceImpl).passwordEncoder(getEnecoder());
	}
	
	@Autowired
	private LoginSucessHandler   sucessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.csrf().disable()
			 .sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
	        .and()		
			.authorizeRequests()
			.antMatchers(resources).permitAll()
			.antMatchers("/","/index", "/usuario/registro").permitAll()			
			.antMatchers("/modificarPerfil/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/administrador/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/productos").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/productos/audio").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/productos/video").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/productos/segMano").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/productos/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().authenticated()
			.and()
			.formLogin().successHandler(sucessHandler).loginPage("/usuario/login").loginProcessingUrl("/usuario/login")
			.defaultSuccessUrl("/usuario/acceder")		
	        .usernameParameter("username")
	        .passwordParameter("password")
	        .permitAll()
	        .and()
	        .logout()       
	        .permitAll()
	        .and().exceptionHandling().accessDeniedPage("/403");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Bean
	public BCryptPasswordEncoder getEnecoder() {
		return new BCryptPasswordEncoder();
	}

}
