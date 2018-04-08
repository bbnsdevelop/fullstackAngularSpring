package br.com.fullstackAngularSpring.builders;

import br.com.fullstackAngularSpring.rest.response.CategoriaResponse;

public class CategoriaResponseBuilder {
	private Long id;
	private String nomeCategoria;
	
	
	public static CategoriaResponseBuilder create(){
		return new CategoriaResponseBuilder();
	}
	public CategoriaResponseBuilder id(Long id){
		this.id = id;
		return this;
	}
	public CategoriaResponseBuilder nomeCategoria(String nomeCategoria){
		this.nomeCategoria = nomeCategoria;
		return this;
	}
	
	public CategoriaResponse build(){
		CategoriaResponse response = new CategoriaResponse();
		response.setId(id);
		response.setNomeCategoria(nomeCategoria);
		return response;
	}
}
