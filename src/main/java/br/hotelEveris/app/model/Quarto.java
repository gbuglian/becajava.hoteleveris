package br.hotelEveris.app.model;

import javax.persistence.*;


@Entity
public class Quarto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private int numQuarto;
	
	private int andar;
	private String situacao;
	
	@ManyToOne
	@JoinColumn(name = "IdTipoQuarto")
	private TipoQuarto tipoQuarto;

	public Quarto(Long id) {
		super();
		this.id = id;
	}

	public Quarto(int numQuarto, int andar, String situacao, TipoQuarto tipoQuarto) {
		super();
		this.numQuarto = numQuarto;
		this.andar = andar;
		this.situacao = situacao;
		this.tipoQuarto = tipoQuarto;
	}

	public Quarto() {
		
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

	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
}
