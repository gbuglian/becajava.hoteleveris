package br.hotelEveris.app.response;

import java.util.List;

import br.hotelEveris.app.model.Cliente;

public class ClienteListResponse extends BaseResponse {

	private List<Cliente> clientes;
	
	public ClienteListResponse(int statusCode, String message){	
		super(statusCode, message);
	}
	
	public ClienteListResponse(int statusCode, String message ,List<Cliente> cliente) {
		super(statusCode, message);
		this.clientes = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
