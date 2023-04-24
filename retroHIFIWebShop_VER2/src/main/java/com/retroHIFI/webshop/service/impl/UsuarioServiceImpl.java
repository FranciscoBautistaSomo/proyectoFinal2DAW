package com.retroHIFI.webshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.retroHIFI.webshop.exception.UserNotEnabledException;
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
		Usuario usuario = usuarioOp.get();				
		if(usuario == null) {
			throw new UsernameNotFoundException("Email o contraseña erroneo");		
		}else if (!(usuario).isEnabled()) {
			throw new UserNotEnabledException("Usuario deshabilitado. Pongase en contacto con el administrador.");			
		}
		return usuarioOp;	
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public Optional<Usuario> findByUsername(String username) throws UsernameNotFoundException{
				Optional<Usuario> usuarioOp = usuarioRepository.findByUsername(username);
				Usuario usuario = usuarioOp.get();				
				if(usuario == null) {
					throw new UsernameNotFoundException("El usuario no existe");		
				}
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
	

}
