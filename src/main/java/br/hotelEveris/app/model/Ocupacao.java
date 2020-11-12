package br.hotelEveris.app.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Ocupacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date data;
	private int QtdDias;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "IdCliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "IdQuarto")
	private Quarto quarto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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
