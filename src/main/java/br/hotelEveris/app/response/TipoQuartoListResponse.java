package br.hotelEveris.app.response;

import java.util.List;

import br.hotelEveris.app.model.TipoQuarto;

public class TipoQuartoListResponse extends BaseResponse {
	
	private List <TipoQuarto> tiposQuartos;

	public TipoQuartoListResponse(int statusCode, String message, List<TipoQuarto> tiposQuartos) {
		super(statusCode, message);
		this.tiposQuartos = tiposQuartos;
	}
	
	public TipoQuartoListResponse(int statusCode, String message) {
		super(statusCode, message);
	}
	
	public TipoQuartoListResponse() {
	}

	public List<TipoQuarto> getTiposQuartos() {
		return tiposQuartos;
	}

	public void setTiposQuartos(List<TipoQuarto> tiposQuartos) {
		this.tiposQuartos = tiposQuartos;
	}
}
