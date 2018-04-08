package br.com.fullstackAngularSpring.rest.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import br.com.fullstackAngularSpring.rest.request.CategoriaRequest;

public interface CategoriaResource {
	
	ResponseEntity<?> getAllCategoria();
	ResponseEntity<?> getByCategoria(Long id);
	ResponseEntity<?> setCategoria(CategoriaRequest requeste, HttpServletResponse response);
	
}
