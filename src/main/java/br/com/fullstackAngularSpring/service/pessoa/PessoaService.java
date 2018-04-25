package br.com.fullstackAngularSpring.service.pessoa;

import java.util.List;

import br.com.fullstackAngularSpring.rest.request.PessoaRequest;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;

public interface PessoaService {

	PessoaResponse criar(PessoaRequest pessoa);

	List<PessoaResponse> getAll();

	void delete(Long id);

}
