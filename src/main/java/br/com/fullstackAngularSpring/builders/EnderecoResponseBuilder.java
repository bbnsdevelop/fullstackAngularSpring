package br.com.fullstackAngularSpring.builders;

import br.com.fullstackAngularSpring.rest.response.EnderecoResponse;

public class EnderecoResponseBuilder {
	
	private Long id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String localidade;
	private String uf;
	private Long pessoaId;
	private String enderecoPrincipal;
	
	public static EnderecoResponseBuilder create() {
		return new EnderecoResponseBuilder();
	}
	public EnderecoResponseBuilder id(Long id) {
		this.id = id;
		return this;
	}	
	public EnderecoResponseBuilder logradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}
	public EnderecoResponseBuilder numero(String numero) {
		this.numero = numero;
		return this;
	}
	public EnderecoResponseBuilder complemento(String complemento) {
		this.complemento = complemento;
		return this;
	}
	public EnderecoResponseBuilder bairro(String bairro) {
		this.bairro = bairro;
		return this;
	}
	public EnderecoResponseBuilder cep(String cep) {
		this.cep = cep;
		return this;
	}
	public EnderecoResponseBuilder localidade(String localidade) {
		this.localidade = localidade;
		return this;
	}
	public EnderecoResponseBuilder uf(String uf) {
		this.uf = uf;
		return this;
	}
	public EnderecoResponseBuilder pessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
		return this;
	}
	public EnderecoResponseBuilder enderecoPrincipal(String enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
		return this;
	}

	public EnderecoResponse build() {
		EnderecoResponse endereco = new EnderecoResponse();
		endereco.setId(id);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setComplemento(complemento);
		endereco.setLocalidade(localidade);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setUf(uf);
		endereco.setEnderecoPrincipal(enderecoPrincipal);
		endereco.setPessoaId(pessoaId);
		
		return endereco;
	}
}
