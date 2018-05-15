package br.com.fullstackAngularSpring.rest.dataTransferObject;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class LancamentoDto {
	
	private Long id;
	
	@NotNull(message = "descricao não pode ser null")
	@Size(min = 3, max = 50)
	private String descricao;
	
	@NotNull(message = "descricao não pode ser null")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dataVencimento;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dataPagamento;
	
	private BigDecimal valor;
	
	private String observacao;
	
	@NotNull(message = "tipo não pode ser null")
	private String tipo;

	@NotNull(message = "catelogoriaId não pode ser null")
	private Long catelogoriaId;

	@NotNull(message = "pessoaId não pode ser null")
	private Long pessoaId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCatelogoriaId() {
		return catelogoriaId;
	}
	public void setCatelogoriaId(Long catelogoriaId) {
		this.catelogoriaId = catelogoriaId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}
	
	
}
