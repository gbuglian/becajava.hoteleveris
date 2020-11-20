package br.hotelEveris.app.model;

import javax.persistence.*;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(unique = true)
	private String cpf;
	
	@Column(unique = true)
	private String hashConta;
	
	public Cliente(Long id) {
		super();
		this.id = id;
	}
	
	public Cliente(String nome, String cpf, String hashConta) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.hashConta = hashConta;
	}
	
	public Cliente() {
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getHashConta() {
		return hashConta;
	}
	public void setHashConta(String hashConta) {
		this.hashConta = hashConta;
	}
}
