package br.com.fullstackAngularSpring.rest.resource;

import org.springframework.http.ResponseEntity;

public interface EnderecoResource {
	ResponseEntity<?> buscaCep(String cep);
}