package br.hotelEveris.app.response;

import java.util.List;

import br.hotelEveris.app.model.Comodidade;
import br.hotelEveris.app.model.TipoQuarto;

public class QuartoResponse extends BaseResponse {
	
	private Long id;
	private int andar;
	private int numQuarto;
	private String situacao;
	private TipoQuarto tipo;
	
	public QuartoResponse(int statusCode, String message, Long id, int andar, int numQuarto, String situacao,TipoQuarto tipo) {
		super(statusCode, message);
		this.id = id;
		this.andar = andar;
		this.numQuarto = numQuarto;
		this.situacao = situacao;
		this.tipo = tipo;
	}
	
	public QuartoResponse(int statusCode, String message) {
		super(statusCode, message);
	}
	
	public QuartoResponse() {
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	public int getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public TipoQuarto getTipo() {
		return tipo;
	}
	public void setTipo(TipoQuarto tipo) {
		this.tipo = tipo;
	}
}
