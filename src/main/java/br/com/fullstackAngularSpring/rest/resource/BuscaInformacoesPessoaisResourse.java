package br.com.fullstackAngularSpring.rest.resource;

import org.springframework.http.ResponseEntity;

import br.com.fullstackAngularSpring.rest.response.DadosPessoaisResponse;

public interface BuscaInformacoesPessoaisResourse {
	ResponseEntity<DadosPessoaisResponse> buscaInformacoes();
	ResponseEntity<?> buscaInformacoesPorCpf(String cpf);
}
