package br.hotelEveris.app.model;

import java.util.Set;

import javax.persistence.*;
import br.hotelEveris.app.model.*;


@Entity
public class Quarto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int andar;
	private String numQuarto;
	private String situacao;
	
	@ManyToOne
	@JoinColumn(name = "IdTipoQuarto")
	private TipoQuarto tipoQuarto;
	
	@ManyToMany(mappedBy = "quarto")
	Set<Comodidade> comododidade;

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

	public String getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(String numQuarto) {
		this.numQuarto = numQuarto;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
}
