package br.hotelEveris.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.hotelEveris.app.model.Cliente;
import br.hotelEveris.app.repository.ClienteRepository;
import br.hotelEveris.app.request.ClienteRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.ClienteListResponse;
import br.hotelEveris.app.response.ClienteResponse;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository _repository;
	
	public BaseResponse inserir(ClienteRequest request){
		
		if(request.getNome() == "" || request.getNome() == null) {
			return new BaseResponse(400, "Erro, Preencha o nome");
		}
		
		if(request.getCpf() == "" || request.getCpf() == null) {
			return new BaseResponse(400, "Erro, Preencha o CPF");
		}
		
		if(request.getHash() == "" || request.getHash() == null) {
			return new BaseResponse(400, "Erro, Preencha o Hash");
		}
		
		Cliente cliente = new Cliente(
				request.getNome(),
				request.getCpf(),
				request.getHash()
				);
		
		_repository.save(cliente);
		
		return new BaseResponse(201, "Cliente inserido com sucesso!");
	}
	
	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = _repository.findById(id);
		
		if (cliente.isEmpty()) {
			return new ClienteResponse(400, "Cliente não informado");
		}
		
		if(id <= 0) {
			return new ClienteResponse(400, "Id Inválido");
		}
		
		return new ClienteResponse(
				200, "Cliente Obtido com sucesso",
				cliente.get().getId(),
				cliente.get().getNome(),
				cliente.get().getCpf()
				);
	}

}
