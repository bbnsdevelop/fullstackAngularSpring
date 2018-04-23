package br.com.fullstackAngularSpring.service.info;

import br.com.fullstackAngularSpring.rest.response.DadosPessoaisResponse;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;

public interface InformacoesPessoaisService {

	DadosPessoaisResponse infoAll();
	PessoaResponse buscaPorCpf(String cpf);

}
