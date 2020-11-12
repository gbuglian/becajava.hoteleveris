package br.hotelEveris.app.response;

import java.util.List;

import br.hotelEveris.app.model.TipoQuarto;

public class TipoQuartoListResponse extends BaseResponse {
	
	private List <TipoQuarto> tiposQuartos;

	public List<TipoQuarto> getTiposQuartos() {
		return tiposQuartos;
	}

	public void setTiposQuartos(List<TipoQuarto> tiposQuartos) {
		this.tiposQuartos = tiposQuartos;
	}
}
