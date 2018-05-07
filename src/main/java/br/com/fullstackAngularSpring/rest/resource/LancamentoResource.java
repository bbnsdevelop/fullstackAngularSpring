package br.com.fullstackAngularSpring.rest.resource;

import org.springframework.http.ResponseEntity;

public interface LancamentoResource {
	ResponseEntity<?> buscaLancamentoPorPessoa(Long id);
	ResponseEntity<?> buscaLancamentos();
	ResponseEntity<?> salvarLancamento(Long id);
	

}
