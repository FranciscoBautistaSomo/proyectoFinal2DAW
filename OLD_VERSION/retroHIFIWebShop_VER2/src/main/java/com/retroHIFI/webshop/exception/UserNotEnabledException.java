package com.retroHIFI.webshop.exception;

public class UserNotEnabledException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7928667057990969497L;

	public UserNotEnabledException() {
		super();		
	}

	public UserNotEnabledException(String message) {
		super("Usuario no habilitado, pongase en contacto con el Administrador");		
	}
	
	
}
