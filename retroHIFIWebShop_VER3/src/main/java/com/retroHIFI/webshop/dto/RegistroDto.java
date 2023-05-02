package com.retroHIFI.webshop.dto;

import lombok.Data;

@Data
public class RegistroDto {
	private String username;
	private String nombre;
	private String apellidos;
	private String email;
	private String direccion;
	private String telefono;
	private String tipo;
	private String password;
	private boolean enabled;
}
