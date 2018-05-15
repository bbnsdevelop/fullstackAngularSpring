package br.com.fullstackAngularSpring.rest.resource;

import org.springframework.http.ResponseEntity;

import br.com.fullstackAngularSpring.rest.dataTransferObject.LancamentoDto;

public interface LancamentoResource {
	ResponseEntity<?> buscaLancamentoPorPessoa(Long id);
	ResponseEntity<?> buscaLancamentos();
	ResponseEntity<?> salvarLancamento(LancamentoDto request);
	

}
