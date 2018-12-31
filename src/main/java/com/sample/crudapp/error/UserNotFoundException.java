package com.sample.crudapp.error;

/**
 * 
 * @author Khanh
 *
 */
@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(long id) {
		super("Could not find user " + id);
	}
}
