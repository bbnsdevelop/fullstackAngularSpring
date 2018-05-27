package br.com.fullstackAngularSpring.builders;

import br.com.fullstackAngularSpring.model.Categoria;

public class CategoriaBuilderEntity {
	private String name;
	
	public static CategoriaBuilderEntity create(){
		return new CategoriaBuilderEntity();
	}
	public CategoriaBuilderEntity name(String name){
		this.name = name;
		return this;
	}
	public Categoria build(){
		Categoria categoria = new Categoria();
		categoria.setNomeCategoria(name);
		return categoria;
	}
}
