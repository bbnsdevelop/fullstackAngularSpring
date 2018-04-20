package br.com.fullstackAngularSpring.rest.resource;

import org.springframework.http.ResponseEntity;

public interface PessoaResource {
	
	ResponseEntity<?> cadastroPessoa();
	ResponseEntity<?> atualizaPessoa();
	ResponseEntity<?> deletaPessoa();
	ResponseEntity<?> buscaPessoa();

}
