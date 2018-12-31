package com.sample.crudapp.error;

/**
 * 
 * @author Khanh
 *
 */
@SuppressWarnings("serial")
public class TechNotFoundException extends RuntimeException {
	public TechNotFoundException(long id) {
		super("Could not found technology " + id);
	}
}
