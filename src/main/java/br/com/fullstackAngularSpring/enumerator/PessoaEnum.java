package br.com.fullstackAngularSpring.enumerator;

public enum PessoaEnum {

	ATIVO("S"), INATIVO("N");
	
	private String valor;
	
	PessoaEnum(String valor){
		this.valor = valor;		
	}

	public String getValor() {
		return valor;
	}

}
