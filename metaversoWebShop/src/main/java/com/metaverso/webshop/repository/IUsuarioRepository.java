package com.metaverso.webshop.repository;

import com.metaverso.webshop.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	//Optional<Usuario> findByEmail(String email);	
	Optional<Usuario> findByNombre(String nombre);
	Boolean existsByNombre(String nombre);
}
