package br.ipen.cestoque.services.exception;

public class FileSaveException extends RuntimeException{
	
	public FileSaveException(String message) {
        super(message);
    }

    public FileSaveException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
