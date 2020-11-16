package br.hotelEveris.app.request;

public class ComodidadeRequest {
	
	private String nome;
	
	public ComodidadeRequest(String nome) {
		super();
		this.nome = nome;
	}
	
	public ComodidadeRequest() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
