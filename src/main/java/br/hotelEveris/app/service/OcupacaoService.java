package br.hotelEveris.app.service;

import br.hotelEveris.app.request.OcupacaoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.OcupacaoListResponse;

public interface OcupacaoService {
	
	public BaseResponse inserir(OcupacaoRequest request);
	
	public OcupacaoListResponse listar();
	
	

}
