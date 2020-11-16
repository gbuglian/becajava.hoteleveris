package br.hotelEveris.app.response;

public class ComodidadeResponse extends BaseResponse {
	
	private Long id;
	private String nome;
	
	public ComodidadeResponse(int statusCode, String message, Long id, String nome) {
		super(statusCode, message);
		this.id = id;
		this.nome = nome;
	}
	
	public ComodidadeResponse(int statusCode, String message) {
		super(statusCode, message);
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
