package br.hotelEveris.app.response;

import java.util.List;

import br.hotelEveris.app.model.Quarto;

public class QuartoListResponse extends BaseResponse{
	
	private List <Quarto> quarto;
	
	public QuartoListResponse(int statusCode, String message, List<Quarto> quarto) {
		super(statusCode, message);
		this.quarto = quarto;
	}
	
	public QuartoListResponse(int statusCode, String message) {
		super(statusCode, message);
	}
	
	public QuartoListResponse() {
	}

	public List<Quarto> getQuarto() {
		return quarto;
	}

	public void setQuarto(List<Quarto> quarto) {
		this.quarto = quarto;
	}
}
