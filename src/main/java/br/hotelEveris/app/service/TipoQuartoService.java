package br.hotelEveris.app.service;

import br.hotelEveris.app.request.TipoQuartoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.TipoQuartoListResponse;
import br.hotelEveris.app.response.TipoQuartoResponse;

public interface TipoQuartoService {
	
	public BaseResponse inserir(TipoQuartoRequest request);
	
	public TipoQuartoResponse obter(Long id);
	
	public TipoQuartoListResponse listar();

}
