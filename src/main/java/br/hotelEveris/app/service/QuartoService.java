package br.hotelEveris.app.service;

import br.hotelEveris.app.request.QuartoPatchRequest;
import br.hotelEveris.app.request.QuartoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.QuartoListResponse;
import br.hotelEveris.app.response.QuartoResponse;

public interface QuartoService {

	public BaseResponse inserir(QuartoRequest request);
	
	public QuartoResponse obter(Long id);
	
	public QuartoListResponse listar(Long id);
	
	public BaseResponse atualizar(Long id,QuartoPatchRequest request);

}
