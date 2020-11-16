package br.hotelEveris.app.response;

import java.util.List;

import br.hotelEveris.app.model.Ocupacao;

public class OcupacaoListResponse extends BaseResponse{
	
	private List <Ocupacao> ocupacoes;
	
	public OcupacaoListResponse(int statusCode, String message) {
		super(statusCode, message);
	}
	
	public OcupacaoListResponse(int statusCode, String message, List<Ocupacao> ocupacoes) {
		super(statusCode, message);
		this.ocupacoes = ocupacoes;
	}
	
	public OcupacaoListResponse() {
		
	}

	public List<Ocupacao> getOcupacoes() {
		return ocupacoes;
	}

	public void setOcupacoes(List<Ocupacao> ocupacoes) {
		this.ocupacoes = ocupacoes;
	}

	
}
