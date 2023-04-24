package com.retroHIFI.webshop.exception;

import javax.naming.AuthenticationException;

public class UsernameNotFoundException extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8120148982996016895L;

	public UsernameNotFoundException() {
		super();
	}

	public UsernameNotFoundException(String explanation) {
		super("Email o contraseña erroneo.");		
	}
	
	

}
