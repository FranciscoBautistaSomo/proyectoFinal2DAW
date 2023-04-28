package com.retroHIFI.webshop.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retroHIFI.webshop.dto.RegistroDto;
import com.retroHIFI.webshop.model.Orden;
import com.retroHIFI.webshop.model.Producto;
import com.retroHIFI.webshop.model.Role;
import com.retroHIFI.webshop.model.Usuario;
import com.retroHIFI.webshop.service.IOrdenService;
import com.retroHIFI.webshop.service.IUsuarioService;
import com.retroHIFI.webshop.dto.LoginDto;
import com.retroHIFI.webshop.dto.RegistroDto;
import com.retroHIFI.webshop.model.Role;
import com.retroHIFI.webshop.model.Usuario;
import com.retroHIFI.webshop.repository.IRoleRepository;
import com.retroHIFI.webshop.repository.IUsuarioRepository;
import com.retroHIFI.webshop.security.JWTGenerator;
import com.retroHIFI.webshop.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	//private AuthenticationManager authenticationManager;
	private IUsuarioRepository iusuarioRepository;
	private IRoleRepository iroleRepository;
	private PasswordEncoder passwordEncoder;
	private JWTGenerator jwtGenerator;
	
	private final Logger logger= LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IOrdenService ordenService;
	
	BCryptPasswordEncoder passEncode= new BCryptPasswordEncoder();
		
	@Autowired
	public UsuarioController( IUsuarioRepository iusuarioRepository,IRoleRepository iroleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator ) {		
		this.iusuarioRepository = iusuarioRepository;
		this.iroleRepository = iroleRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtGenerator = jwtGenerator;
	}

	// /usuario/registro
	@GetMapping("/registro")
	public String create() {
		return "usuario/registro";
	}
	
	@PostMapping("save")
	public String save(RegistroDto registroDto) {
		if (iusuarioRepository.existsByUsername(registroDto.getUsername())) {
//			 return new ResponseEntity<>("¡Nombre de usuario existente!!",
//			 HttpStatus.BAD_REQUEST);
		}
		Usuario user = new Usuario();
		user.setUsername(registroDto.getUsername());
		user.setNombre(registroDto.getNombre());
		user.setApellidos(registroDto.getApellidos());
		user.setEmail(registroDto.getEmail());
		user.setDireccion(registroDto.getDireccion());
		user.setTelefono(registroDto.getTelefono());
		user.setTipo("ROLE_USER");
		user.setPassword(passwordEncoder.encode((registroDto.getPassword())));
		user.setEnabled(true);

		Role roles = iroleRepository.findByAuthority("ROLE_USER").get();
		user.setRoles(Collections.singletonList(roles));

		iusuarioRepository.save(user);

		return "redirect:/";
		// return new ResponseEntity<>("User registered success!", HttpStatus.OK);

	}
	
//	@PostMapping("/save")
//	public String save(Usuario usuario) {
//		logger.info("Usuario registro: {}", usuario);
//		usuario.setTipo("USER");
//		usuario.setPassword( passEncode.encode(usuario.getPassword()));
//		usuarioService.save(usuario);		
//		return "redirect:/";
//	}
	
	@GetMapping("/login")
	public String login() {
		return "usuario/login";
	}
	
	//@PostMapping("/acceder")
	@GetMapping("/acceder")
	public String acceder(Usuario usuario, HttpSession session) {
		logger.info("Accesos : {}", usuario);
		
		Optional<Usuario> user=usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString()));
		logger.info("Usuario de db: {}", user.get());
		
		if (user.isPresent()) {
			session.setAttribute("idusuario", user.get().getId());
			
			if (user.get().getTipo().equals("ADMIN")) {
				logger.info("If, Soy del tipo: {}", user.get().getTipo());
				//logger.info("If, idusuario: {}", idusuario);
				return "redirect:/administrador";
			}else {
				logger.info("Else, Soy del tipo: {}", user.get().getTipo());
				return "redirect:/";
			}
		}else {
			logger.info("Usuario no existe");
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/perfil")
	public String entrarPerfil(Model model, HttpSession session) {		
		
		Optional<Usuario> usuarioOp=usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString()));
		logger.info("Usuario de db: {}", usuarioOp.get());
		
		Usuario usuario= usuarioOp.get();

		model.addAttribute("usuarios", usuario);
		
//		Usuario usuario = usuarioService.findByEmail(emailLogueado);
//		
//		List<Orden> ordenes = ordenService.findByUsuario(usuario);
//		
//		model.addAttribute("ordenes", ordenes);
		
		return "usuario/perfil";		
	}
	
	@GetMapping("/modificarPerfil/{id}")
	public String modificarPerfil(@PathVariable Integer id, Model model) {
		Optional<Usuario> usuario=usuarioService.findById(id);
		//Usuario usuario = usuarioOp.get();
		model.addAttribute("usuario", usuario);
		return "usuario/modificarPerfil";
	}
	
	@PostMapping("/update")
	public String update(Usuario usuario) {		
		if (usuario != null) {			
			Role roles = iroleRepository.findByAuthority("ROLE_USER").get();
			usuario.setRoles(Collections.singletonList(roles));			
			usuarioService.update(usuario);
		}		
		return "redirect:/";
	}
	
	@GetMapping("/deshabilitar/{id}")
	public String deshabilitar(@PathVariable Integer id) {
		
		Usuario usuario = new Usuario();
		usuario=usuarioService.get(id).get();	
		
		//deshabilitar usuario si está habilitado o habilitarlo si esta deshabilitado 
		if (usuario.isEnabled()) {			
			usuario.setEnabled(false);			
		}else if(!usuario.isEnabled()) {
			usuario.setEnabled(true);			
		}		
		usuarioService.update(usuario);
		return "redirect:/ ";
	}	
	
	@GetMapping("/compras")
	public String obtenerCompras(Model model, HttpSession session) {
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		
		Usuario usuario= usuarioService.findById(  Integer.parseInt(session.getAttribute("idusuario").toString()) ).get();
		List<Orden> ordenes= ordenService.findByUsuario(usuario);
		logger.info("ordenes {}", ordenes);
		
		model.addAttribute("ordenes", ordenes);
		
		return "usuario/compras";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleCompra(@PathVariable Integer id, HttpSession session, Model model) {
		logger.info("Id de la orden: {}", id);
		Optional<Orden> orden=ordenService.findById(id);
		
		Usuario usuario= usuarioService.findById(  Integer.parseInt(session.getAttribute("idusuario").toString()) ).get();
		model.addAttribute("usuario", usuario);
		model.addAttribute("orden",orden.get());
		model.addAttribute("detalles", orden.get().getDetalle());		
		//session
		model.addAttribute("sesion", session.getAttribute("idusuario"));
		return "usuario/detallecompra";
	}
	
	@GetMapping("/cerrar")
	public String cerrarSesion( HttpSession session ) {
		session.removeAttribute("idusuario");
		return "redirect:/logout";
	}
}
