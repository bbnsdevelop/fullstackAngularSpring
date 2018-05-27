package br.com.fullstackAngularSpring.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.fullstackAngularSpring.model.enums.TipoLancamento;
/**
 * @author Bruno Batista
 *
 */
@Entity
@Table(name = "TB_LANCAMENTO")
public class Lancamento {

	@Id
	@Column(name = "ID", length=50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DESCRICAO", nullable = false, length=50)
	private String descricao;
	
	@Column(name = "DATA_VENCI", nullable = false)
	private LocalDate dataVencimento;
	
	@Column(name = "DATA_PAGTO")
	private LocalDate dataPagamento;
	
	@Column(name = "VALOR")
	private BigDecimal valor;
	
	@Column(name = "OBSERVACAO", length=200)
	private String observacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO", length=20)
	private TipoLancamento tipo;
	
	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIA", nullable = false)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA", nullable = false)
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public TipoLancamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
