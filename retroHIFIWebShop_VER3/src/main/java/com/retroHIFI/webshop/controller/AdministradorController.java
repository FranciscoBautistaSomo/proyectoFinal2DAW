package com.retroHIFI.webshop.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.retroHIFI.webshop.model.Orden;
import com.retroHIFI.webshop.model.Producto;
import com.retroHIFI.webshop.service.IOrdenService;
import com.retroHIFI.webshop.service.IProductoService;
import com.retroHIFI.webshop.service.IUsuarioService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private IProductoService productoService;

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IOrdenService ordenService;

	@GetMapping("")
	public String hom(Model model, String busqueda, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "4") int pageSize) {
//		List<Producto> productos = productoService.findAll();
//		model.addAttribute("productos", productos);
//		return "administrador/home";
		List<Producto> productos;

		if (busqueda != null) {
			productos = productoService.buscador(busqueda);
		} else {
			productos = productoService.findAll();
		}
		
		int start = page * pageSize;
		int end = Math.min((start + pageSize), productos.size());
		List<Producto> productosPaginados = productos.subList(start, end);
		
		model.addAttribute("productos", productosPaginados);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", (int) Math.ceil((double) productos.size() / pageSize));
		model.addAttribute("pageSize", pageSize);
		
		long totalProductos = productos.size();
		model.addAttribute("totalProductos", totalProductos);
		
		return "administrador/home";
	}

	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.findAll());
		return "administrador/usuarios";
	}

	@GetMapping("/ordenes")
	public String ordenes(Model model) {
		model.addAttribute("ordenes", ordenService.findAll());
		return "administrador/ordenes";
	}

	@GetMapping("/detalles/{id}")
	public String detalle(Model model, @PathVariable Integer id) {

		Orden orden = ordenService.findById(id).get();

		model.addAttribute("detalles", orden.getDetalle());

		return "administrador/detalleorden";
	}

}
