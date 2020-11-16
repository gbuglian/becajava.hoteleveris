package br.hotelEveris.app.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Ocupacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String data;
	private int QtdDias;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "IdCliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "IdQuarto")
	private Quarto quarto;
	
	public Ocupacao(String data, int qtdDias, Cliente cliente, Quarto quarto) {
		super();
		this.data = data;
		this.QtdDias = qtdDias;
		this.status = "N";
		this.cliente = cliente;
		this.quarto = quarto;
	}
	
	public Ocupacao(Long id) {
		super();
		this.id = id;
	}
	
	public Ocupacao() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQtdDias() {
		return QtdDias;
	}

	public void setQtdDias(int qtdDias) {
		QtdDias = qtdDias;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}	
}
