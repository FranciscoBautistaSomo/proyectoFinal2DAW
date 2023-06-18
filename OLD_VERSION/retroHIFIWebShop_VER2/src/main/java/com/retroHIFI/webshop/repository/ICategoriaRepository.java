package com.retroHIFI.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.retroHIFI.webshop.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{
}
