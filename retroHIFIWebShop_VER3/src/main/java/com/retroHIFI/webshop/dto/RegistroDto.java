package com.retroHIFI.webshop.dto;

import lombok.Data;
import javax.validation.constraints.*;



@Data
public class RegistroDto {
	@Size(min=3, message="El username debe tener al menos 3 caracteres." )
	@NotEmpty
	private String username;
	@Size(min=3, message="El nombre debe tener al menos 3 caracteres." )
	@NotEmpty
	private String nombre;
	@Size(min=5, message="El apellido debe tener al menos 5 caracteres." )
	@NotEmpty
	private String apellidos;
	@NotEmpty
	@Email
	private String email;
	
	private String direccion;
	private String telefono;
	private String tipo;
	@Size(min=4, message="La contraseña debe tener al menos 4 caracteres." )
	@NotEmpty
	private String password;
	private boolean enabled;
}
