package com.retroHIFI.webshop.service;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retroHIFI.webshop.model.Producto;


public interface IProductoService {
		public Producto save(Producto producto);
		public Optional<Producto> get(Integer id);
		public Optional<Producto> findByIdCategoria(Integer idCategoria);
		public void update(Producto producto);
		public void delete(Integer id);
		public List<Producto> findAll();
}
