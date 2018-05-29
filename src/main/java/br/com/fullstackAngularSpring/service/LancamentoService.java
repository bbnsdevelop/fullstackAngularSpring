package br.com.fullstackAngularSpring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.fullstackAngularSpring.rest.dataTransferObject.LancamentoDto;

public interface LancamentoService {

	LancamentoDto saveLancamento(LancamentoDto request);

	List<LancamentoDto> findAll();

	LancamentoDto findByLancamentoId(Long id);

	void deleteLancamentoId(Long id);

	Page<LancamentoDto> findLancamentosByPessoaId(Long id, Pageable page);

}
