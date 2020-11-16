package br.hotelEveris.app.response;

public class ClienteResponse extends BaseResponse{
	
	private Long id;
	private String nome;
	private String cpf;
	
	public ClienteResponse(int statusCode, String message) {
		super(statusCode, message);
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public ClienteResponse(int statusCode, String message, Long id, String nome, String cpf) {
		super(statusCode, message);
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
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
}
