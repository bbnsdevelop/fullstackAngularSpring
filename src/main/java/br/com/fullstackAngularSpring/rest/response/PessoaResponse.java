package br.com.fullstackAngularSpring.rest.response;

import java.time.LocalDate;
import java.util.List;

public class PessoaResponse {
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String rg;

	private LocalDate dataNascimento;
	
	private List<EnderecoResponse> enderecos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<EnderecoResponse> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoResponse> enderecos) {
		this.enderecos = enderecos;
	}
}
