package com.retroHIFI.webshop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retroHIFI.webshop.model.Usuario;
import com.retroHIFI.webshop.repository.IUsuarioRepository;
import com.retroHIFI.webshop.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	@Autowired
	private IUsuarioRepository usuarioRepository;
		
	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
