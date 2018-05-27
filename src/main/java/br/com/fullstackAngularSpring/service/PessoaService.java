package br.com.fullstackAngularSpring.service;

import java.util.List;

import br.com.fullstackAngularSpring.rest.request.PessoaRequest;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;

public interface PessoaService {

	PessoaResponse criar(PessoaRequest pessoa);

	List<PessoaResponse> getAll();

	void delete(Long id);

	PessoaResponse upDatePessoa(PessoaRequest request);

	PessoaResponse buscaPorId(Long id);

	PessoaResponse upDatePessoa(Long id, PessoaRequest request);

}
