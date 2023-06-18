package com.retroHIFI.webshop.service;

import java.util.List;

import com.retroHIFI.webshop.model.Orden;

public interface IOrdenService {
			List<Orden> findAll();
			Orden save(Orden orden);
			String generarNumeroOrden();
}
