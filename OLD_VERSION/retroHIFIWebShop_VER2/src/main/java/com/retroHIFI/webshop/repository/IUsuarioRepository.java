package com.retroHIFI.webshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retroHIFI.webshop.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByEmail(String email);	
	Optional<Usuario> findByUsername(String username);
    Boolean existsByUsername(String username);
}
