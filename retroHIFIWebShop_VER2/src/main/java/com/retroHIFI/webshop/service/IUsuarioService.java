package com.retroHIFI.webshop.service;

import java.util.*;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.retroHIFI.webshop.exception.UserNotEnabledException;
import com.retroHIFI.webshop.model.Usuario;

public interface IUsuarioService {
		List<Usuario> findAll();
		Optional<Usuario> findById(Integer id) throws UsernameNotFoundException, UserNotEnabledException;
		Usuario save(Usuario usuario);
		public void update(Usuario usuario);
		Optional<Usuario> findByUsername(String username);
		Optional<Usuario> findByEmail(String email);
}
