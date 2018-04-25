package br.com.fullstackAngularSpring.rest.resource;

import org.springframework.http.ResponseEntity;

import br.com.fullstackAngularSpring.rest.request.PessoaRequest;

public interface PessoaResource {
	
	ResponseEntity<?> cadastroPessoa(PessoaRequest pessoa);
	ResponseEntity<?> atualizaPessoa();
	ResponseEntity<?> deletaPessoa(Long id);
	ResponseEntity<?> buscaTodasPessoas();

}
