package br.com.fullstackAngularSpring.rest.resource;

import org.springframework.http.ResponseEntity;

import br.com.fullstackAngularSpring.rest.request.LancamentoRequest;

public interface LancamentoResource {
	ResponseEntity<?> buscaLancamentoPorPessoa(Long id);
	ResponseEntity<?> buscaLancamentos();
	ResponseEntity<?> salvarLancamento(LancamentoRequest request, Long id);
	

}
