package br.com.fullstackAngularSpring.service.cep;

import br.com.fullstackAngularSpring.rest.response.CepEndereco;

public interface CepService {
	CepEndereco getCep(String buscarCep);
}
