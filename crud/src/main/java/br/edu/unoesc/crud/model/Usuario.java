package br.edu.unoesc.crud.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Usuario = bibliotecario
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String login;
	private String senha;
	private String biblioteca;
	
	@ElementCollection(fetch = FetchType.EAGER, targetClass = Roles.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "usuario_roles")
	@Column(name = "role")
	List<Roles> roles;
	
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
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(String biblioteca) {
		this.biblioteca = biblioteca;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public Usuario(Long id, String nome, String login, String senha, String biblioteca, List<Roles> roles) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.biblioteca = biblioteca;
		this.roles = roles;
	}

	public Usuario() {
		
	}

	public void criptografarSenha() {
		if (this.login != null && senha != null) {
			this.senha = new BCryptPasswordEncoder().encode(this.senha);
		}
	}


	
	
	
}
