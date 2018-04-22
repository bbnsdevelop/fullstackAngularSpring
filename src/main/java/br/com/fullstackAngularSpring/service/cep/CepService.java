package br.com.fullstackAngularSpring.service.cep;

import br.com.fullstackAngularSpring.rest.response.CepEnderecoResponse;

public interface CepService {
	CepEnderecoResponse getCep(String buscarCep);
}
