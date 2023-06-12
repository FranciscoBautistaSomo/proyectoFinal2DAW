package com.retroHIFI.webshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retroHIFI.webshop.model.Producto;
import com.retroHIFI.webshop.repository.IProductoRepository;
import com.retroHIFI.webshop.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;
	
	
	@Override
	public Producto save(Producto producto) {
		
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {
		return productoRepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public void delete(Integer id) {
		productoRepository.deleteById(id);		
	}

	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> findByIdCategoria(Integer idCategoria) {
		return productoRepository.findById(idCategoria);
	}

	@Override
	public List<Producto> buscador(String busqueda) {
		return productoRepository.buscador(busqueda);
	}

	@Override
	public List<Producto> buscarAudio(String busqueda) {
		return productoRepository.buscarAudio(busqueda);
	}

	@Override
	public List<Producto> buscarVideo(String busqueda) {
		return productoRepository.buscarVideo(busqueda);
	}

	@Override
	public List<Producto> buscarSegMano(String busqueda) {
		return productoRepository.buscarSegMano(busqueda);
	}

}
