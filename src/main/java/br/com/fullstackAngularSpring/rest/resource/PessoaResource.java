package br.com.fullstackAngularSpring.rest.resource;

import org.springframework.http.ResponseEntity;

import br.com.fullstackAngularSpring.rest.request.PessoaRequest;

public interface PessoaResource {
	
	ResponseEntity<?> cadastroPessoa(PessoaRequest pessoa);
	ResponseEntity<?> atualizaPessoa(PessoaRequest request);
	ResponseEntity<?> deletaPessoa(Long id);
	ResponseEntity<?> buscaTodasPessoas();
	ResponseEntity<?> buscaPessoaId(Long id);

}
