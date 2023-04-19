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

import com.retroHIFI.webshop.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpingBootSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailServiceImpl;

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**",
			"/assets/**", "/vendor/**", "/images/**" };

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailServiceImpl).passwordEncoder(getEnecoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		 .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
        .and()		
		.authorizeRequests()
		.antMatchers(resources).permitAll()
		.antMatchers("/**","/index", "/modificarPerfil/**").permitAll()
		.antMatchers("/administrador/**").access("hasRole('ADMIN')")
		.antMatchers("/productos/**").access("hasRole('ADMIN')")
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/usuario/login")
			.permitAll()
			.defaultSuccessUrl("/usuario/acceder")
			.failureUrl("/login?error=true")
           .usernameParameter("username")
           .passwordParameter("password")
           .and()
           .logout()
           .permitAll()
           .logoutSuccessUrl("/login?logout");
	}

	@Bean
	public BCryptPasswordEncoder getEnecoder() {
		return new BCryptPasswordEncoder();
	}

}
