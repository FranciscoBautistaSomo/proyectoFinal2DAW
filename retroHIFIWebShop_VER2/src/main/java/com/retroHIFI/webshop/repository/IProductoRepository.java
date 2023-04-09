package com.retroHIFI.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retroHIFI.webshop.model.Producto;
@Repository
public interface IProductoRepository  extends JpaRepository<Producto, Integer>{
	
}
