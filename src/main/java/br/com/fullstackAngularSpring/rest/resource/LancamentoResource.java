package br.com.fullstackAngularSpring.rest.resource;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import br.com.fullstackAngularSpring.rest.dataTransferObject.LancamentoDto;

public interface LancamentoResource {
	ResponseEntity<?> buscaLancamentosPaginacao(Long id, Pageable page);
	ResponseEntity<?> buscaLancamentoPorid(Long id);
	ResponseEntity<?> deletarLancamento(Long id);
	ResponseEntity<?> buscaLancamentos();
	ResponseEntity<?> salvarLancamento(LancamentoDto request);
	ResponseEntity<?> buscaLancamentosPaginacaoDataVenimento(Long id, LocalDate dataVencimentoInicio, LocalDate dataVencimentoFim, Pageable page);
	

}
