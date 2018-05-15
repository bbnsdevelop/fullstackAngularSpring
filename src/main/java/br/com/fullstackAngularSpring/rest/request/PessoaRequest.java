package br.com.fullstackAngularSpring.rest.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

public class PessoaRequest {
	
	private Long id;
	
	@NotNull(message = "nome da pessoa não pode ser null")
	private String nome;
	
	@NotNull(message = "cpf da pessoa não pode ser null")
	private String cpf;
	
	@NotNull(message = "rg da pessoa não pode ser null")
	private String rg;

	@NotNull(message = "dataNascimento da pessoa não pode ser null")
	private LocalDate dataNascimento;
	
	@NotNull(message = "ativo da pessoa não pode ser null")
	private String ativo;
	
	private List<EnderecoRequest> enderecos;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<EnderecoRequest> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoRequest> enderecos) {
		this.enderecos = enderecos;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	
	
}
