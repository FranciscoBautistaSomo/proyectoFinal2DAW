package com.retroHIFI.webshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.retroHIFI.webshop.model.Categoria;
import com.retroHIFI.webshop.model.Producto;
import com.retroHIFI.webshop.repository.ICategoriaRepository;
import com.retroHIFI.webshop.repository.IProductoRepository;
import com.retroHIFI.webshop.service.ICategoriaService;

public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private  ICategoriaRepository categoriaRepository;	
	
	@Override
	public List<Categoria> findAll() {		
		return categoriaRepository.findAll();
	}	

}
