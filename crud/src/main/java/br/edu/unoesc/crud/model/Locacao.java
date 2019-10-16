package br.edu.unoesc.crud.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Locacao {

	@Id
	@GeneratedValue
	private Long id;

	private String cliente;

	private String exemplar;
	private String data;
	private int dias;

	public void calculaDias() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataInput = null;
		try {
			dataInput = sdf.parse(this.data);
		} catch (Exception e) {

		}
		Calendar date = new GregorianCalendar();
		date.setTime(dataInput);
		// Cria um objeto calendar com a data atual
		Calendar today = Calendar.getInstance();
		// Obtém a idade baseado no ano
		this.dias = date.get(Calendar.DAY_OF_MONTH) - today.get(Calendar.DAY_OF_MONTH);
		date.add(Calendar.DAY_OF_MONTH, this.dias);
		if (today.before(date)) {
			this.dias--;
		}
	}

	public Locacao(Long id, String cliente, String exemplar, String data, int dias) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.exemplar = exemplar;
		this.data = data;
		this.dias = dias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getExemplar() {
		return exemplar;
	}

	public void setExemplar(String exemplar) {
		this.exemplar = exemplar;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public Locacao() {

	}

}
