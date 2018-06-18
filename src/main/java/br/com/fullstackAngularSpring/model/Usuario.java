package br.com.fullstackAngularSpring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="TB_USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 20, nullable = false)
	private Long id;
	
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;
	
	@Column(name = "SENHA", length = 150, nullable = false)
	private String senha;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_USUARIO_PERMISSAO", joinColumns = @JoinColumn(name = "ID_USUARIO"), 
			   inverseJoinColumns = @JoinColumn(name = "ID_PERMISSAO"))
	private List<Permissao> permissoes;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	

}
