package br.com.fullstackAngularSpring.builders;

import java.time.LocalDate;
import java.util.List;

import br.com.fullstackAngularSpring.rest.response.EnderecoResponse;
import br.com.fullstackAngularSpring.rest.response.PessoaResponse;

public class PessoaResponseBuilder {
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String rg;
	
	private List<EnderecoResponse> enderecos;

	private LocalDate dataNascimento;
	
	public static PessoaResponseBuilder create() {
		return new PessoaResponseBuilder();
	}
	
	public PessoaResponseBuilder id(Long id) {
		this.id = id;
		return this;
	}
	
	public PessoaResponseBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public PessoaResponseBuilder cpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	
	public PessoaResponseBuilder rg(String rg) {
		this.rg = rg;
		return this;
	}
	
	public PessoaResponseBuilder enderecos(List<EnderecoResponse> enderecos) {
		this.enderecos = enderecos;
		return this;
	}
	
	public PessoaResponseBuilder dataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}
	
	public PessoaResponse build() {
		PessoaResponse pessoa = new PessoaResponse();
		
		pessoa.setId(id);
		pessoa.setNome(nome);
		pessoa.setRg(rg);
		pessoa.setCpf(cpf);
		pessoa.setEnderecos(enderecos);
		pessoa.setDataNascimento(dataNascimento);		
		return pessoa;
	}

}
