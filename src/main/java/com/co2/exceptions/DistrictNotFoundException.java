package com.co2.exceptions;

public class DistrictNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DistrictNotFoundException(Long id) {
        super("District Id not found : " + id);
    }

}
