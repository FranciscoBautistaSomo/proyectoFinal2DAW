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
	
	@ManyToOne
	private Usuario usuario;

	
	
	
}
