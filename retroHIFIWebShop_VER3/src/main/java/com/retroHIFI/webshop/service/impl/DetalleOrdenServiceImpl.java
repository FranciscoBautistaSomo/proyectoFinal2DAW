package com.retroHIFI.webshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retroHIFI.webshop.model.DetalleOrden;
import com.retroHIFI.webshop.repository.IDetalleOrdenRepository;
import com.retroHIFI.webshop.service.IDetalleOrdenService;

@Service
public class DetalleOrdenServiceImpl implements IDetalleOrdenService{

	@Autowired
	private IDetalleOrdenRepository detalleOrdenRepository;
	
	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {		
		return detalleOrdenRepository.save(detalleOrden);
	}

}
