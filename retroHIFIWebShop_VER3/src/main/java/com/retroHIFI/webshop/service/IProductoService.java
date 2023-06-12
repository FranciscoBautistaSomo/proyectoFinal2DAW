package com.retroHIFI.webshop.service;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retroHIFI.webshop.model.Producto;


public interface IProductoService {
		public Producto save(Producto producto);
		public Optional<Producto> get(Integer id);
		public Optional<Producto> findByIdCategoria(Integer idCategoria);
		public void update(Producto producto);
		public void delete(Integer id);
		public List<Producto> findAll();
		public List<Producto> buscador(String busqueda);
		public List<Producto> buscarAudio(String busqueda);
		public List<Producto> buscarVideo(String busqueda);
		public List<Producto> buscarSegMano(String busqueda);
				
}
