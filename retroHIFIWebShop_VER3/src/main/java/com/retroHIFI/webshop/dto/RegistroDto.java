package com.retroHIFI.webshop.dto;

import lombok.Data;
import javax.validation.constraints.*;



@Data
public class RegistroDto {
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellidos;
	@NotEmpty
	private String email;	
	private String direccion;
	private String telefono;
	private String tipo;
	@NotEmpty
	private String password;
	private boolean enabled;
}
