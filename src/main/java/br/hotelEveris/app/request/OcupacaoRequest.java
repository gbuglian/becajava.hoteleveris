package br.hotelEveris.app.request;

import java.util.Date;

import br.hotelEveris.app.model.Cliente;
import br.hotelEveris.app.model.Quarto;

public class OcupacaoRequest {

	private Date data;
	private int qtdDias;
	private Long clienteId;
	private Long quartoId;
	
	public OcupacaoRequest(Date data, int qtdDias, Long clienteId, Long quartoId) {
		super();
		this.data = data;
		this.qtdDias = qtdDias;
		this.clienteId = clienteId;
		this.quartoId = quartoId;
	}

	public OcupacaoRequest() {
		
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getQuartoId() {
		return quartoId;
	}

	public void setQuartoId(Long quartoId) {
		this.quartoId = quartoId;
	}

	
}