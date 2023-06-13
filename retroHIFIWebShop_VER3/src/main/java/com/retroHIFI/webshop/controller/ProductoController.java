package com.retroHIFI.webshop.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.UploadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.retroHIFI.webshop.model.Producto;
import com.retroHIFI.webshop.repository.ICategoriaRepository;
import com.retroHIFI.webshop.repository.IProductoRepository;
import com.retroHIFI.webshop.service.ICategoriaService;
import com.retroHIFI.webshop.service.IProductoService;
import com.retroHIFI.webshop.service.UploadFileService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private UploadFileService upload;
	
	@GetMapping("")
	public String show(Model model) {
		
		model.addAttribute("productos", productoService.findAll());
		return "productos/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	
	@PostMapping("/save")
	public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
		LOGGER.info("Este es el objeto producto {}", producto);
		
		//Imagen
		if (producto.getId()==null) {//cuando se crea un producto
			String nombreImagen = upload.saveImage(file);
			producto.setImagen(nombreImagen);
		} 
		
		producto.setEnabled(true);
		productoService.save(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto producto = new Producto();
		Optional<Producto> optionalProducto=productoService.get(id);
		producto = optionalProducto.get();
		//LOGGER.info("Producto buscado: {}", producto);
		model.addAttribute("producto", producto);
		return "productos/edit";
	}
	
	@PostMapping("/update")
	public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
		Producto p = new Producto();
		p=productoService.get(producto.getId()).get();
		if(file.isEmpty()) {//editamos el producto pero no cambiamos la imagen
			
			producto.setImagen(p.getImagen());
		}else {// cuando se edita la imagen
			//eliminar imagen cuando no sea la imagen por defecto
			if (!p.getImagen().equals("default.jpg")) {
				upload.deleteImage(p.getImagen());
			}
			String nombreImagen = upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}
		producto.setUsuario(p.getUsuario());
		producto.setEnabled(true);
		productoService.update(producto);
		return "redirect:/productos ";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		Producto p = new Producto();
		p=productoService.get(id).get();	
		
		//eliminar imagen cuando no sea la imagen por defecto
		if (!p.getImagen().equals("default.jpg")) {
			upload.deleteImage(p.getImagen());
		}
		
		productoService.delete(id);
		return "redirect:/productos ";
	}
	
	@GetMapping("/deshabilitar/{id}")
	public String deshabilitar(@PathVariable Integer id) {
		
		Producto p = new Producto();
		p=productoService.get(id).get();	
		
		//deshabilitar pruducto si está habilitado o habilitarlo si esta deshabilitado 
		if (p.isEnabled()) {			
			p.setEnabled(false);			
		}else if(!p.isEnabled()) {
			p.setEnabled(true);			
		}		
		productoService.update(p);
		return "redirect:/ ";
	}
	
	@GetMapping("/audio")
	public String listarAudio(Model model, String busqueda, String resultBusqueda, @RequestParam(defaultValue = "0") int page) {
		
		List<Producto> productos;
		Page<Producto> productosPage = null;
		
		String noEncontrado = " ";
		
		if (busqueda != null) {
			productos = productoService.buscarAudio(busqueda);
		} else {
			productosPage = productoRepository.mostrarAudios(PageRequest.of(page, 3));
			productos = productosPage.getContent();
		}
		
		if(productos.isEmpty()) {
			noEncontrado = "El producto, "+"\""+busqueda+"\""+", no existe.";
			resultBusqueda = noEncontrado;
			model.addAttribute("notFound", noEncontrado);
		}

		model.addAttribute("productos", productos);
		model.addAttribute("productosPage", productosPage);

		List<Producto> totalProductPage = productoRepository.mostrarAudio();
		long total = totalProductPage.size();
		model.addAttribute("totalProductos", total);	
				
		model.addAttribute("nombreCat", productoRepository.getNombreCategoria(1));
		
		return "productos/categoria";
	}
	
	@GetMapping("/video")
	public String listarVideo(Model model, String busqueda, String resultBusqueda, @RequestParam(defaultValue = "0") int page) {
		List<Producto> productos;
		Page<Producto> productosPage = null;
		
		String noEncontrado = " ";
		
		if (busqueda != null) {
			productos = productoService.buscarVideo(busqueda);
		} else {
			productosPage = productoRepository.mostrarVideos(PageRequest.of(page, 3));
			productos = productosPage.getContent();
		}
		
		if(productos.isEmpty()) {
			noEncontrado = "El producto, "+"\""+busqueda+"\""+", no existe.";
			resultBusqueda = noEncontrado;
			model.addAttribute("notFound", noEncontrado);
		}
		
		model.addAttribute("productos", productos);
		model.addAttribute("productosPage", productosPage);	
		
		List<Producto> totalProductPage = productoRepository.mostrarVideo();
		long total = totalProductPage.size();
		model.addAttribute("totalProductos", total);
		
		
		model.addAttribute("nombreCat", productoRepository.getNombreCategoria(2));
		
		return "productos/categoria";
	}
	
	@GetMapping("/segMano")
	public String listarSegMano(Model model, String busqueda, String resultBusqueda, @RequestParam(defaultValue = "0") int page) {
		List<Producto> productos;
		Page<Producto> productosPage = null;
		
		String noEncontrado = " ";
		
		if (busqueda != null) {
			productos = productoService.buscarSegMano(busqueda);
		} else {
			productosPage = productoRepository.mostrarSegManos(PageRequest.of(page, 3));
			productos = productosPage.getContent();
		}
		
		if(productos.isEmpty()) {
			noEncontrado = "El producto, "+"\""+busqueda+"\""+", no existe.";
			resultBusqueda = noEncontrado;
			model.addAttribute("notFound", noEncontrado);
		}
		
		
		model.addAttribute("productos", productos);
		model.addAttribute("productosPage", productosPage);	
		
		List<Producto> totalProductPage = productoRepository.mostrarSegMano();
		long total = totalProductPage.size();
		model.addAttribute("totalProductos", total);
		model.addAttribute("nombreCat", productoRepository.getNombreCategoria(3));
		
		return "productos/categoria";
	}
	
	
	
}
