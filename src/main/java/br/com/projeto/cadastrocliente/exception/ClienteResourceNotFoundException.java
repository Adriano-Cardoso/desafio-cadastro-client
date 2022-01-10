package br.com.projeto.cadastrocliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ClienteResourceNotFoundException(String message) {
		super(message);
	}
}
