package com.retroHIFI.webshop.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import com.retroHIFI.webshop.model.DetalleOrden;
import com.retroHIFI.webshop.model.Orden;
import com.retroHIFI.webshop.model.Producto;
import com.retroHIFI.webshop.model.Usuario;
import com.retroHIFI.webshop.repository.IDetalleOrdenRepository;
import com.retroHIFI.webshop.service.IDetalleOrdenService;
import com.retroHIFI.webshop.service.IOrdenService;
import com.retroHIFI.webshop.service.IProductoService;
import com.retroHIFI.webshop.service.IUsuarioService;

import com.retroHIFI.webshop.repository.IRoleRepository;
import com.retroHIFI.webshop.repository.IUsuarioRepository;

@Controller
//@RequestMapping("usuario/home")
@RequestMapping("")
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private IProductoService productoService;

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IOrdenService ordenService;

	@Autowired
	private IDetalleOrdenService detalleOrdenService;

	// para almacenar los detalles de la orden
	List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

	// datos de la orden
	Orden orden = new Orden();

	@GetMapping("usuario/home")
	public String home(Model model, HttpSession session, String busqueda,
	@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int pageSize) {
		List<Producto> productos; 
		
		//model.addAttribute("productos", productos);
		
		if (busqueda != null) {
			productos = productoService.buscador(busqueda);
			} else {
			productos = productoService.findAll();
			}

		// Session
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		
		int start = page * pageSize;
		int end = Math.min((start + pageSize), productos.size());
		List<Producto> productosPaginados = productos.subList(start, end);

		model.addAttribute("productos", productosPaginados);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", (int) Math.ceil((double) productos.size() / pageSize));
		model.addAttribute("pageSize", pageSize);		

		long totalProductos = productos.size();
		model.addAttribute("totalProductos", totalProductos);	

		//return "usuario/home";
		return "usuario/home";
	}

	@GetMapping("/productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model, HttpSession session) {

		Object idsesion = (session.getAttribute("idusuario"));
		log.info("id enviado de la sesion {}", idsesion);
		if (idsesion == null) {		
			Producto producto = new Producto();
			Optional<Producto> productoOptional = productoService.get(id);
			producto = productoOptional.get();
			model.addAttribute("producto", producto);			
			//return "usuario/productohome";
			return "productohome";
		} else {
			Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
			log.info("idusuario logeado {}", usuario.getId());
			log.info("tipo logeado {}", usuario.getTipo());
			Producto producto = new Producto();
			Optional<Producto> productoOptional = productoService.get(id);
			producto = productoOptional.get();
			model.addAttribute("producto", producto);
			model.addAttribute("usuario", usuario);
			return "usuario/productohome";
		}
	}

	@PostMapping("/cart")
	public String addcart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model, HttpSession session) {
		DetalleOrden detalleOrden = new DetalleOrden();
		Producto producto = new Producto();
		double sumaTotal = 0;

		Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();

		Optional<Producto> optionalProducto = productoService.get(id);
		log.info("Producto añadido: {}", optionalProducto.get());
		log.info("Cantidad: {}", cantidad);
		producto = optionalProducto.get();

		detalleOrden.setCantidad(cantidad);
		detalleOrden.setPrecio(producto.getPrecio());
		detalleOrden.setNombre(producto.getNombre());
		detalleOrden.setTotal(producto.getPrecio() * cantidad);
		detalleOrden.setProducto(producto);

		// validar que le producto no se añada 2 veces
		Integer idProducto = producto.getId();
		boolean ingresado = detalles.stream().anyMatch(p -> p.getProducto().getId() == idProducto);

		if (!ingresado) {
			detalles.add(detalleOrden);
		}

		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();
		orden.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		model.addAttribute("usuario", usuario);
		return "usuario/carrito";
	}

	// quitar un producto del carrito
	@GetMapping("/delete/cart/{id}")
	public String deleteProductoCart(@PathVariable Integer id, Model model) {

		// Lista nueva de pruductos
		List<DetalleOrden> ordenesNueva = new ArrayList<DetalleOrden>();

		for (DetalleOrden detalleOrden : detalles) {
			if (detalleOrden.getProducto().getId() != id) {
				ordenesNueva.add(detalleOrden);
			}
		}

		// poner la nueva lista con los productos restantes
		detalles = ordenesNueva;

		double sumaTotal = 0;
		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

		orden.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);

		return "usuario/carrito";
	}

	@GetMapping("/getCart")
	public String getCart(Model model, HttpSession session) {

		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);

		model.addAttribute("sesion", session.getAttribute("idusuario"));
		return "/usuario/carrito";
	}

	@GetMapping("/order")
	public String order(Model model, HttpSession session) {
		Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();

		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		model.addAttribute("usuario", usuario);

		return "usuario/resumenorden";
	}

	// Guardar la orden
	@GetMapping("/saveOrder")
	public String saveOrder(HttpSession session) {
		Date fechaCreacion = new Date();
		orden.setFechaCreacion(fechaCreacion);
		orden.setNumero(ordenService.generarNumeroOrden());

		// Usuario
		Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();

		orden.setUsuario(usuario);
		ordenService.save(orden);

		// guardar detalles
		for (DetalleOrden dt : detalles) {
			Producto p = new Producto();
			dt.setOrden(orden);
			// Recuperar producto del detalle
			p = productoService.get(dt.getProducto().getId()).get();
			// Cantidad vendida
			int vendido = (int) dt.getCantidad();
			// Actualizar stock
			int stock = p.getCantidad() - vendido;
			// Actualizar stock producto.
			if (stock >= 0) {
				p.setCantidad(stock);
				// Guardar producto actualizado
				productoService.save(p);
			} else {
				log.info("Sin STOCK");
			}
			// Guardar detalle
			detalleOrdenService.save(dt);
		}

		// limpiar lista y orden
		orden = new Orden();
		detalles.clear();

		return "redirect:/usuario/home";
	}

//	@PostMapping("/search")
//	public String searchProduct(@RequestParam String nombre, Model model) {
//		log.info("Nombre del producto: {}", nombre);
//		List<Producto> productos = productoService.findAll().stream().filter(p -> p.getNombre().contains(nombre)).collect(Collectors.toList());
//		model.addAttribute("productos", productos);
//		return "usuario/home";		
//	}

}
