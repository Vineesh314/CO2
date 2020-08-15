package com.co2.exceptions;

public class ClientNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientNotFoundException(Long id) {
        super("Client id not found : " + id);
    }

}
