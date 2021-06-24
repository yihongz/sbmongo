package br.com.grokhong.sbmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super("Object not found. Id " + msg);
	}
}
