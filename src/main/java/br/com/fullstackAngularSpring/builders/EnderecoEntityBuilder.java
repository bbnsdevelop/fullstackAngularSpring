package br.com.fullstackAngularSpring.builders;

import br.com.fullstackAngularSpring.model.endereco.Endereco;
import br.com.fullstackAngularSpring.model.pessoa.Pessoa;

public class EnderecoEntityBuilder {
	
	private Long id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String localidade;
	private String uf;
	private String enderecoPrincipal;
	private Pessoa pessoa;
	
	public static EnderecoEntityBuilder create() {
		return new EnderecoEntityBuilder();
	}
	public EnderecoEntityBuilder id(Long id) {
		this.id = id;
		return this;
	}	
	public EnderecoEntityBuilder logradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}
	public EnderecoEntityBuilder numero(String numero) {
		this.numero = numero;
		return this;
	}
	public EnderecoEntityBuilder complemento(String complemento) {
		this.complemento = complemento;
		return this;
	}
	public EnderecoEntityBuilder bairro(String bairro) {
		this.bairro = bairro;
		return this;
	}
	public EnderecoEntityBuilder cep(String cep) {
		this.cep = cep;
		return this;
	}
	public EnderecoEntityBuilder localidade(String localidade) {
		this.localidade = localidade;
		return this;
	}
	public EnderecoEntityBuilder uf(String uf) {
		this.uf = uf;
		return this;
	}
	public EnderecoEntityBuilder enderecoPrincipal(String enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
		return this;
	}
	public EnderecoEntityBuilder pessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		return this;
	}


	public Endereco build() {
		Endereco endereco = new Endereco();
		endereco.setCodigo(id);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setComplemento(complemento);
		endereco.setCidade(localidade);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setEstado(uf);
		endereco.setFlagEnderecoPrincipal(enderecoPrincipal);
		endereco.setPessoa(pessoa);
		
		return endereco;
	}
}
