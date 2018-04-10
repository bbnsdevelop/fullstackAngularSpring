package br.com.fullstackAngularSpring.rest.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoriaRequest {
	
	@NotNull
	@Size(min = 3, max = 50)
	private String nomeCategoria;

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
}
