package br.hotelEveris.app.request;

import java.util.List;
import java.util.Set;

import br.hotelEveris.app.model.Comodidade;
import br.hotelEveris.app.model.TipoQuarto;

public class QuartoRequest {
	
	private int andar;
	private int numQuarto;
	private String situacao;
	private Long tipoQuartoId;
	private List<ComodidadeRequest> comodidades;
	
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
	public Long getTipoQuartoId() {
		return tipoQuartoId;
	}
	public void setTipoQuartoId(Long tipoQuartoId) {
		this.tipoQuartoId = tipoQuartoId;
	}
	public List<ComodidadeRequest> getComodidades() {
		return comodidades;
	}
	public void setComodidades(List<ComodidadeRequest> comodidades) {
		this.comodidades = comodidades;
	}

	
	
}
