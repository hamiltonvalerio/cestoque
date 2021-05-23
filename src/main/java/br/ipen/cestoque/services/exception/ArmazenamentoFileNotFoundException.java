package br.ipen.cestoque.services.exception;

public class ArmazenamentoFileNotFoundException extends ArmazenamentoException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArmazenamentoFileNotFoundException(String message) {
		super(message);
	}

	public ArmazenamentoFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
