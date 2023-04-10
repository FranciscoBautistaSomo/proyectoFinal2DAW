package com.retroHIFI.webshop.service;

import java.util.*;

import com.retroHIFI.webshop.model.Usuario;

public interface IUsuarioService {
		List<Usuario> findAll();
		Optional<Usuario> findById(Integer id);
		Usuario save(Usuario usuario);
		Optional<Usuario> findByUsername(String username);
		Optional<Usuario> findByEmail(String email);
}
