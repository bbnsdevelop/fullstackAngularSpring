package br.com.fullstackAngularSpring.service.lancamento;

import java.util.List;

import br.com.fullstackAngularSpring.rest.request.LancamentoRequest;
import br.com.fullstackAngularSpring.rest.response.LancamentoResponse;

public interface LancamentoService {

	LancamentoResponse saveLancamento(Long pessoaId, Long catId, LancamentoRequest request);

	List<LancamentoResponse> findAll();

	List<LancamentoResponse> findByPessoa(Long id);

}
