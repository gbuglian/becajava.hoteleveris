package br.hotelEveris.app.response;

public class TipoQuartoResponse extends BaseResponse {
	
	private Long id;
	private String descricao;
	private Double valor;
	
	public TipoQuartoResponse(int statusCode, String message, Long id, String descricao, Double valor) {
		super(statusCode, message);
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public TipoQuartoResponse(int statusCode, String message) {
		super(statusCode, message);
	}
	
	public TipoQuartoResponse() {
		
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
