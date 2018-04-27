package br.com.fullstackAngularSpring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PessoaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public PessoaException() {

	}

	public PessoaException(String mensage) {
		super(mensage);

	}

}
