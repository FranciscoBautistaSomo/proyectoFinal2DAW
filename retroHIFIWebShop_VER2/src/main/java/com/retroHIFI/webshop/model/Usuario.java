package com.retroHIFI.webshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.retroHIFI.webshop.model.Orden;
import com.retroHIFI.webshop.model.Producto;
import com.retroHIFI.webshop.model.Role;

import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String nombre;
	private String apellidos;
	private String email;
	private String direccion;
	private String telefono;
	private String tipo;
	private String password;
	private boolean enabled;
	
	@OneToMany(mappedBy = "usuario")
	private List<Producto> productos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Orden> ordenes;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();
    
    public List<Role> getRole(){
    	return roles;
    }
    
    public void setRole(List<Role> roles) {
    	this.roles = roles;
    }

	}
