package com.retroHIFI.webshop.security;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.retroHIFI.webshop.model.Role;
import com.retroHIFI.webshop.model.Usuario;
import com.retroHIFI.webshop.repository.IUsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
		private IUsuarioRepository usuarioRepository;
		
		@Autowired
		public CustomUserDetailsService(IUsuarioRepository usuarioRepository) {
			this.usuarioRepository = usuarioRepository;
		}
		
		@Override
		public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
			Usuario user = usuarioRepository.findByNombre(nombre).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
			return new User(user.getNombre(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
		}
		
		private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
	        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	    }
}
