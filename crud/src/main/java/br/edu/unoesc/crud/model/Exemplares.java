package br.edu.unoesc.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exemplares {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String autor;
	private String ano;
	private String categoria;
	private Integer quantidade;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Exemplares(long id, String nome, String autor, String ano, String categoria, Integer quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.ano = ano;
		this.categoria = categoria;
		this.quantidade = quantidade;
	}
	public Exemplares() {
		
	}
	
	
	
}
