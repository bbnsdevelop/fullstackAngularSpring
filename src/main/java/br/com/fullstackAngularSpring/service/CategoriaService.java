package br.com.fullstackAngularSpring.service;

import br.com.fullstackAngularSpring.rest.request.CategoriaRequest;
import br.com.fullstackAngularSpring.rest.response.CategoriaResponse;
import br.com.fullstackAngularSpring.rest.response.CategoriaResponseList;

public interface CategoriaService {
	
	CategoriaResponseList getAll();
	CategoriaResponse getById(Long id);
	CategoriaResponse create(CategoriaRequest requeste);
}
