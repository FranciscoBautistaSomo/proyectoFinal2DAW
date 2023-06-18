package com.retroHIFI.webshop.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.retroHIFI.webshop.exception.UserNotEnabledException;
import com.retroHIFI.webshop.model.Producto;
import com.retroHIFI.webshop.model.Role;
import com.retroHIFI.webshop.model.Usuario;
import com.retroHIFI.webshop.repository.IUsuarioRepository;
import com.retroHIFI.webshop.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	@Autowired
	private IUsuarioRepository usuarioRepository;
		
	@Override
	public Optional<Usuario> findById(Integer id) throws UsernameNotFoundException, UserNotEnabledException{
		Optional<Usuario> usuarioOp = usuarioRepository.findById(id);			
		return usuarioOp;	
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public Optional<Usuario> findByUsername(String username) throws UsernameNotFoundException, UserNotEnabledException{
				Optional<Usuario> usuarioOp = usuarioRepository.findByUsername(username);
				return usuarioOp;				
	}
	
	@Override
	public Optional<Usuario> findByEmail(String email) {
		
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public void update(Usuario usuario) {
		usuarioRepository.save(usuario);		
	}

	@Override
	public Optional<Usuario> get(Integer id) {
		return usuarioRepository.findById(id);
	}
	
	

	
}
