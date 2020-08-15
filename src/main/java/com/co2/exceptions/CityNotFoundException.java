package com.co2.exceptions;

public class CityNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityNotFoundException(Long id) {
        super("City Id not found : " + id);
    }

}
