package com.retroHIFI.webshop.service;

import java.util.List;
import java.util.Optional;

import com.retroHIFI.webshop.model.Orden;
import com.retroHIFI.webshop.model.Usuario;

public interface IOrdenService {
			List<Orden> findAll();
			Optional<Orden> findById(Integer id);
			Orden save(Orden orden);
			String generarNumeroOrden();
			List<Orden>findByUsuario(Usuario usuario);
}
