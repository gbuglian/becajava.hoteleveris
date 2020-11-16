package br.hotelEveris.app.response;

import java.util.List;

import br.hotelEveris.app.model.Comodidade;

public class ComodidadeListResponse extends BaseResponse{
	
	public ComodidadeListResponse(int statusCode, String message, List <Comodidade> comodidade) {
		super(statusCode, message);
		this.comodidades = comodidade;
	}
	
	public ComodidadeListResponse(int statusCode, String message) {
		super(statusCode, message);
	}

	private List <Comodidade> comodidades;

	public List<Comodidade> getComodidades() {
		return comodidades;
	}

	public void setComodidades(List<Comodidade> comodidades) {
		this.comodidades = comodidades;
	}
}
