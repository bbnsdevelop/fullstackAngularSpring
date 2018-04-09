package br.com.fullstackAngularSpring.service.categoria;

import br.com.fullstackAngularSpring.rest.request.CategoriaRequest;
import br.com.fullstackAngularSpring.rest.response.CategoriaResponse;
import br.com.fullstackAngularSpring.rest.response.CategoriaResponseList;

public interface CategoriaService {
	
	CategoriaResponseList getAll();
	CategoriaResponse getById(Long id);
	CategoriaResponse create(CategoriaRequest requeste);
}
