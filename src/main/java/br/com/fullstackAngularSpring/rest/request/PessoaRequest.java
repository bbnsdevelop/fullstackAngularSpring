package br.com.fullstackAngularSpring.rest.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class PessoaRequest {
	
	@NotNull(message = "nome da pessoa não pode ser null")
	private String nome;
	
	@NotNull(message = "cpf da pessoa não pode ser null")
	private String cpf;
	
	@NotNull(message = "rg da pessoa não pode ser null")
	private String rg;

	@NotNull(message = "dataNascimento da pessoa não pode ser null")
	private LocalDate dataNascimento;
}
