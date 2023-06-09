package com.retroHIFI.webshop.model;

import javax.persistence.*;

import com.retroHIFI.webshop.model.Usuario;

import lombok.Data;

@Entity
@Table(name="productos")
@Data
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private double precio;
	private int cantidad;
	private boolean enabled;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "categoria_id_categoria")
	private Categoria categoria;	
	
}
