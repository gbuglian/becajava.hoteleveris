package br.hotelEveris.app.response;

import java.util.Date;

import br.hotelEveris.app.model.Cliente;
import br.hotelEveris.app.model.Quarto;

public class OcupacaoResponse extends BaseResponse {

	private Long id;
	private String data;
	private int QtdDias;
	private String status;
	private Cliente cliente;
	private Quarto quarto;
	
	public OcupacaoResponse(int statusCode, String message, Long id, String data, int qtdDias, String status,Cliente cliente, Quarto quarto) {
		super(statusCode, message);
		this.id = id;
		this.data = data;
		QtdDias = qtdDias;
		this.status = status;
		this.cliente = cliente;
		this.quarto = quarto;
	}
	
	public OcupacaoResponse(int statusCode, String message) {
		super(statusCode, message);
	}
	
	public OcupacaoResponse() {
		
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
