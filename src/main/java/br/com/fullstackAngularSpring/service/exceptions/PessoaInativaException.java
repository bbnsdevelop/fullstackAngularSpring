package br.com.fullstackAngularSpring.service.exceptions;

public class PessoaInativaException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public PessoaInativaException() {

	}

	public PessoaInativaException(String mensage) {
		super(mensage);

	}
	

}
