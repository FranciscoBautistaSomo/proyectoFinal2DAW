package com.metaverso.webshop.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Usuarios")
@Data
public class Usuario  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
	
}
