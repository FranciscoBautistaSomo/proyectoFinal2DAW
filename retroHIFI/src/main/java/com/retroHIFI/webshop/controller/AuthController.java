package com.retroHIFI.webshop.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retroHIFI.webshop.dto.AuthResponseDTO;
import com.retroHIFI.webshop.dto.LoginDto;
import com.retroHIFI.webshop.dto.RegistroDto;
import com.retroHIFI.webshop.model.Role;
import com.retroHIFI.webshop.model.Usuario;
import com.retroHIFI.webshop.repository.IRoleRepository;
import com.retroHIFI.webshop.repository.IUsuarioRepository;
import com.retroHIFI.webshop.security.JWTGenerator;

//@RestController
@Controller
@RequestMapping("/auth")
public class AuthController {
		private AuthenticationManager authenticationManager;
		private IUsuarioRepository iusuarioRepository;
		private IRoleRepository iroleRepository;
		private PasswordEncoder passwordEncoder;
		
		private JWTGenerator jwtGenerator;
		
		@Autowired
		public AuthController(AuthenticationManager authenticationManager, IUsuarioRepository iusuarioRepository,
				IRoleRepository iroleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator ) {
			
			this.authenticationManager = authenticationManager;
			this.iusuarioRepository = iusuarioRepository;
			this.iroleRepository = iroleRepository;
			this.passwordEncoder = passwordEncoder;
			this.jwtGenerator = jwtGenerator;
		}
		
		@PostMapping("login")
		public  ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
			                loginDto.getNombre(),
			                loginDto.getPassword()));		
			 SecurityContextHolder.getContext().setAuthentication(authentication);
			 String token = jwtGenerator.generarToken(authentication);
			 return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
			
		}
		
		
//		@PostMapping("login")
//	    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
//	        Authentication authentication = authenticationManager.authenticate(
//	                new UsernamePasswordAuthenticationToken(
//	                loginDto.getUsername(),
//	                loginDto.getPassword()));
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//	        String token = jwtGenerator.generateToken(authentication);
//	        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
//	    }
		
		@PostMapping("registro")
		public ResponseEntity<String> registro(@RequestBody RegistroDto registroDto){
				if (iusuarioRepository.existsByNombre(registroDto.getNombre())) {
					return new ResponseEntity<>("¡Nombre de usuario existente!!", HttpStatus.BAD_REQUEST);
				}
				
				Usuario user = new Usuario();
				user.setNombre(registroDto.getNombre());
		        user.setPassword(passwordEncoder.encode((registroDto.getPassword())));
		        
		        Role roles = iroleRepository.findByNombre("USER").get();
		        user.setRoles(Collections.singletonList(roles));
		        
		        iusuarioRepository.save(user);
		        
		        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
				
		}
		
		
		
}
