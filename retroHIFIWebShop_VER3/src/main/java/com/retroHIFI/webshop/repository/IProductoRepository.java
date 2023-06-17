package com.retroHIFI.webshop.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.retroHIFI.webshop.model.Producto;

import java.util.*;

@Repository
public interface IProductoRepository  extends JpaRepository<Producto, Integer>{
	
	@Query(value="SELECT * FROM productos p WHERE p.categoria_id_categoria = 1 AND p.enabled = 1", nativeQuery=true)
	List<Producto> mostrarAudio();
	
	@Query(value="SELECT * FROM productos p WHERE p.categoria_id_categoria = 1 AND p.enabled = 1", nativeQuery=true)
	Page<Producto> mostrarAudios(Pageable pageable);	
	
	@Query(value="SELECT * FROM productos p WHERE p.categoria_id_categoria = 2 AND p.enabled = 1", nativeQuery=true)
	List<Producto> mostrarVideo();
	
	@Query(value="SELECT * FROM productos p WHERE p.categoria_id_categoria = 2 AND p.enabled = 1", nativeQuery=true)
	Page<Producto> mostrarVideos(Pageable pageable);
	
	@Query(value="SELECT * FROM productos p WHERE p.categoria_id_categoria = 3 AND p.enabled = 1", nativeQuery=true)
	List<Producto> mostrarSegMano();
	
	@Query(value="SELECT * FROM productos p WHERE p.categoria_id_categoria = 3 AND p.enabled = 1", nativeQuery=true)
	Page<Producto> mostrarSegManos(Pageable pageable);
	
	@Query(value="SELECT nombre FROM categoria c WHERE c.id_categoria LIKE %:id_categoria%", nativeQuery=true)
	String  getNombreCategoria(@Param("id_categoria") Integer id_categoria);
	
	@Query(value="SELECT * FROM productos p WHERE p.nombre LIKE %:busqueda% AND p.enabled = 1", nativeQuery=true)
	List<Producto> buscador(@Param("busqueda") String busqueda);
	
	@Query(value="SELECT * FROM productos p WHERE p.nombre LIKE %:busqueda% AND p.categoria_id_categoria = 1 AND p.enabled = 1", nativeQuery=true)
	List<Producto> buscarAudio(@Param("busqueda") String busqueda);
	
	@Query(value="SELECT * FROM productos p WHERE p.nombre LIKE %:busqueda% AND p.categoria_id_categoria = 2 AND p.enabled = 1", nativeQuery=true)
	List<Producto> buscarVideo(@Param("busqueda") String busqueda);
	
	@Query(value="SELECT * FROM productos p WHERE p.nombre LIKE %:busqueda% AND p.categoria_id_categoria = 3 AND p.enabled = 1", nativeQuery=true)
	List<Producto> buscarSegMano(@Param("busqueda") String busqueda);
	
}
