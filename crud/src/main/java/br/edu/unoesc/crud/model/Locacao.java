package br.edu.unoesc.crud.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Locacao {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Exemplares exemplar;
	private LocalDate data;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Exemplares getExemplar() {
		return exemplar;
	}
	public void setExemplar(Exemplares exemplar) {
		this.exemplar = exemplar;
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Locacao(Long id, Cliente cliente, Exemplares exemplar, LocalDate data) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.exemplar = exemplar;
		this.data = data;
	}
	
	public Locacao() {
		
	}

	
	
	
	
}
