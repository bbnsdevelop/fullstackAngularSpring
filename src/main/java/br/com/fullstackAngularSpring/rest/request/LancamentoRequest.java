package br.com.fullstackAngularSpring.rest.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LancamentoRequest {
	
	private Long catelogoriaId;
	private String descricao;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private BigDecimal valor;
	private String observacao;
	private String tipo;
	private Long pessoaId;

}
