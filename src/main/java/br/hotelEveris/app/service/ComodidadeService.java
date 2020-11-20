package br.hotelEveris.app.service;

import br.hotelEveris.app.request.ComodidadeRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.ComodidadeResponse;

public interface ComodidadeService {
	
	public BaseResponse inserir(ComodidadeRequest request);
	
	public ComodidadeResponse obter(Long id);
	
	

}
