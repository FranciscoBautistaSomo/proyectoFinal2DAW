package com.retroHIFI.webshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.retroHIFI.webshop.exception.UserNotEnabledException;
import com.retroHIFI.webshop.model.Role;
import com.retroHIFI.webshop.model.Usuario;
import com.retroHIFI.webshop.repository.IUsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	IUsuarioRepository userRepository;
	
	@Autowired
	HttpSession session;
	
	private Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, UserNotEnabledException {
		log.info("Este es el username {}", username);
		Usuario appUser = new Usuario();
		//Buscar el usuario con el repositorio y si no existe lanzar una exepcion
		Optional<Usuario> optionalUser = userRepository.findByUsername(username);
		Usuario userTest = optionalUser.get();		
		if(userTest == null) {
			throw new UsernameNotFoundException("Email o contraseña erroneo");		
		}else if (!(userTest).isEnabled()) {
			throw new UserNotEnabledException("Usuario deshabilitado. Pongase en contacto con el administrador.");			
		}else if (userTest != null && userTest.isEnabled()) {
			log.info("Este es el username {}", optionalUser.get().getId());
			session.setAttribute("idusuario", optionalUser.get().getId());
			System.out.println(session);
			appUser = userTest;
		}
		
		//Mapear nuestra lista de Authority con la de spring security
		List grantList = new ArrayList();
	    for (Role authority: appUser.getRole()) {
	        // ROLE_USER, ROLE_ADMIN,..
	        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
	            grantList.add(grantedAuthority);
	    }
	    
	    UserDetails usuarioDetalles = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), appUser.getEnabled(), true, true, true, 
	    												 grantList);
		
		return usuarioDetalles;
	}

}
