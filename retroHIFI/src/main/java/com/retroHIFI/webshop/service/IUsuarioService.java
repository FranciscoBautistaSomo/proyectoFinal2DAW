package com.retroHIFI.webshop.service;

import java.util.Optional;

import com.retroHIFI.webshop.model.Usuario;

public interface IUsuarioService {
		Optional<Usuario> findById(Integer id);
}
