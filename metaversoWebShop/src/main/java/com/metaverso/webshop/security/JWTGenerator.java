package com.metaverso.webshop.security;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTGenerator {
		public String generarToken(Authentication authentication) {
			String nombre = authentication.getName();
			Date currentDate = new Date();
			Date expireDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION );
			
			String token = Jwts.builder()
								.setSubject(nombre)
								.setIssuedAt(currentDate)
								.setExpiration(expireDate)
								.signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
				                .compact();
			return token;
		}
		
		public String getNombreDeJWT(String token) {
	        Claims claims = Jwts.parser()
	                .setSigningKey(SecurityConstants.JWT_SECRET)
	                .parseClaimsJws(token)
	                .getBody();
	        return claims.getSubject();
	    }
		
		public boolean validarToken(String token) {
			try {
	            Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token);
	            return true;
	        } catch (Exception ex) {
	            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
	        }
		}
}
