package br.hotelEveris.app.service;

import br.hotelEveris.app.request.ClienteRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.ClienteResponse;

public interface ClienteService {
	
	public BaseResponse inserir(ClienteRequest request);
	
	public ClienteResponse obter(Long id);
	
	

}
