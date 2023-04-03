package com.metaverso.webshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.metaverso.webshop.security.JwtAuthEntryPoint;
import com.metaverso.webshop.security.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private JwtAuthEntryPoint authEntryPoint;
	
	private CustomUserDetailsService userDetailsService;

	@Autowired
	public SecurityConfig(CustomUserDetailsService userDetailsService, JwtAuthEntryPoint authEntryPoint) {
		this.userDetailsService = userDetailsService;
		this.authEntryPoint = authEntryPoint;
	}
	
	String[] resources = new String[] {
			"/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**","/assets/**", "/vendor/**"
	};

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
						.exceptionHandling()
						.authenticationEntryPoint(authEntryPoint)
						 .and()
						 .sessionManagement()
						 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						 .and()
						.authorizeRequests()
						.antMatchers(resources).permitAll()
						.antMatchers("/administrador/**", "/productos/**", "/edit/**").permitAll()
						.antMatchers("/auth/**").permitAll()
						.anyRequest()
						.authenticated()
						.and()
						.httpBasic();
		 http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	PasswordEncoder passwordEncoder() {	return new BCryptPasswordEncoder();}
	
	@Bean
	public  JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }

}
