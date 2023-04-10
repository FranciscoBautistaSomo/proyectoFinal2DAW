package com.retroHIFI.webshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retroHIFI.webshop.model.Orden;
import com.retroHIFI.webshop.model.Usuario;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer>{
	List<Orden> findByUsuario(Usuario usuario);
}
