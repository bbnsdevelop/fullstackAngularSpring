package br.com.fullstackAngularSpring.rest.response;

import java.util.List;

public class DadosPessoaisResponse {
	
	private List<PessoaResponse> pessoas;
	
	public List<PessoaResponse> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<PessoaResponse> pessoas) {
		this.pessoas = pessoas;
	}
	
	
}
