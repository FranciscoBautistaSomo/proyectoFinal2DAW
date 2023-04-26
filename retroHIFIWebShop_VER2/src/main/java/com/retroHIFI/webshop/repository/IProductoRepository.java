package com.retroHIFI.webshop.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.retroHIFI.webshop.model.Producto;

import java.util.*;

@Repository
public interface IProductoRepository  extends JpaRepository<Producto, Integer>{
	
	@Query(value="SELECT * FROM Productos p WHERE p.categoria_id_categoria = 1 AND p.enabled = 1", nativeQuery=true)
	List<Producto> mostrarAudio();
	
	@Query(value="SELECT * FROM Productos p WHERE p.categoria_id_categoria = 2 AND p.enabled = 1", nativeQuery=true)
	List<Producto> mostrarVideo();
	
	@Query(value="SELECT * FROM Productos p WHERE p.categoria_id_categoria = 3 AND p.enabled = 1", nativeQuery=true)
	List<Producto> mostrarSegMano();
	
}
