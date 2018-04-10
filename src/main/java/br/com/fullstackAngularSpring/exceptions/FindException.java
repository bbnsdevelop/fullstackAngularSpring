package br.com.fullstackAngularSpring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Não há informações para a consulta")
public class FindException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public FindException() {

	}

	public FindException(String mensage) {
		super(mensage);

	}
}
