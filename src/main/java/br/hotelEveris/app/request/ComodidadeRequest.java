package br.hotelEveris.app.request;

public class ComodidadeRequest {
	
	private Long id;
	private String nome;
	
	public ComodidadeRequest(String nome) {
		super();
		this.nome = nome;
	}
	
	public ComodidadeRequest() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
