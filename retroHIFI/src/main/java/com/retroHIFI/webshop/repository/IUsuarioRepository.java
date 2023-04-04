package com.retroHIFI.webshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retroHIFI.webshop.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	//Optional<Usuario> findByEmail(String email);	
	Optional<Usuario> findByNombre(String nombre);
	Boolean existsByNombre(String nombre);
}
