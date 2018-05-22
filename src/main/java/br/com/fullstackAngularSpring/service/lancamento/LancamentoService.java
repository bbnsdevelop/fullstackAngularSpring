package br.com.fullstackAngularSpring.service.lancamento;

import java.util.List;

import br.com.fullstackAngularSpring.rest.dataTransferObject.LancamentoDto;

public interface LancamentoService {

	LancamentoDto saveLancamento(LancamentoDto request);

	List<LancamentoDto> findAll();

	List<LancamentoDto> findByPessoa(Long id);

	void deleteLancamentoId(Long id);

}
