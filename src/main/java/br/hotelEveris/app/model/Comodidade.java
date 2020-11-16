package br.hotelEveris.app.model;

import javax.persistence.*;


@Entity
public class Comodidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	public Comodidade(Long id) {
		super();
		this.id = id;
	}
	
	public Comodidade(String nome) {
		super();
		this.nome = nome;
	}
	
	public Comodidade() {
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
