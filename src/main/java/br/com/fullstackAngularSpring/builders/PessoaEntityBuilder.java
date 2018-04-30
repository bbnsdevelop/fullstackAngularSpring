package br.com.fullstackAngularSpring.builders;

import java.time.LocalDate;

import br.com.fullstackAngularSpring.model.pessoa.Pessoa;

public class PessoaEntityBuilder {
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String rg;
	
	private LocalDate dataNascimento;
	
	public static PessoaEntityBuilder create() {
		return new PessoaEntityBuilder();
	}
	
	public PessoaEntityBuilder id(Long id) {
		this.id = id;
		return this;
	}
	public PessoaEntityBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public PessoaEntityBuilder cpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	
	public PessoaEntityBuilder rg(String rg) {
		this.rg = rg;
		return this;
	}
	
	
	public PessoaEntityBuilder dataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}
	
	public Pessoa build() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(id);
		pessoa.setNome(nome);
		pessoa.setRg(rg);
		pessoa.setCpf(cpf);
		pessoa.setDataNascimento(dataNascimento);		
		return pessoa;
	}
}
