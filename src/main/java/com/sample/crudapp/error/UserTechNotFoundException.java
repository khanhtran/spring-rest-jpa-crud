package com.sample.crudapp.error;

/**
 * 
 * @author Khanh
 *
 */
@SuppressWarnings("serial")
public class UserTechNotFoundException extends RuntimeException {
	public UserTechNotFoundException(long id) {
		super("UserTech not found " + id);
	}
}
