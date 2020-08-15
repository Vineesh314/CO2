package com.co2.exceptions;

public class SensorNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public SensorNotFoundException(Long id) {
		super("Sensor id not found: "+ id);
	}
	

}
