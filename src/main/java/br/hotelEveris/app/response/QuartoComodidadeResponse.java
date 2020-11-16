package br.hotelEveris.app.response;

import br.hotelEveris.app.model.Comodidade;
import br.hotelEveris.app.model.Quarto;

public class QuartoComodidadeResponse extends BaseResponse{
	
	private Long id;
	private Quarto quarto;
	private Comodidade comodidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public Comodidade getComodidade() {
		return comodidade;
	}
	public void setComodidade(Comodidade comodidade) {
		this.comodidade = comodidade;
	}
}
