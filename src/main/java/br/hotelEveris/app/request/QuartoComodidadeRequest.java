package br.hotelEveris.app.request;

import br.hotelEveris.app.model.Comodidade;
import br.hotelEveris.app.model.Quarto;

public class QuartoComodidadeRequest {
	
	private Quarto quarto;
	private Comodidade comodidade;
	
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
