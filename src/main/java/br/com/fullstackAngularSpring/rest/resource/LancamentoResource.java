package br.com.fullstackAngularSpring.rest.resource;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import br.com.fullstackAngularSpring.rest.dataTransferObject.LancamentoDto;

public interface LancamentoResource {
	ResponseEntity<?> buscaLancamentoPorPessoa(Long id);
	ResponseEntity<?> buscaLancamentosPaginacao(Long id, Pageable page);
	ResponseEntity<?> deletarLancamento(Long id);
	ResponseEntity<?> buscaLancamentos();
	ResponseEntity<?> salvarLancamento(LancamentoDto request);
	

}
