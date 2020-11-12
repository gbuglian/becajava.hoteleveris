package br.hotelEveris.app.response;

import java.util.List;

import br.hotelEveris.app.model.Comodidade;

public class ComodidadeListResponse extends BaseResponse{
	
	private List <Comodidade> comodidades;

	public List<Comodidade> getComodidades() {
		return comodidades;
	}

	public void setComodidades(List<Comodidade> comodidades) {
		this.comodidades = comodidades;
	}
}
