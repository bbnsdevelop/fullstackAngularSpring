package br.com.fullstackAngularSpring.rest.request;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
	
	@NotBlank(message="Nome da categoria não pode ser nulo")	
	private String nomeCategoria;

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
}
