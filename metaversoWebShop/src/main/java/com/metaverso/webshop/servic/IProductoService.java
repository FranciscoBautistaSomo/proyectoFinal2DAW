package com.metaverso.webshop.servic;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metaverso.webshop.model.Producto;


public interface IProductoService {
		public Producto save(Producto producto);
		public Optional<Producto> get(Integer id);
		public void update(Producto producto);
		public void delete(Integer id);
		public List<Producto> findAll();

}
