package br.hotelEveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hotelEveris.app.model.TipoQuarto;
import br.hotelEveris.app.repository.TipoQuartoRepository;
import br.hotelEveris.app.request.TipoQuartoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.TipoQuartoListResponse;
import br.hotelEveris.app.response.TipoQuartoResponse;

@Service
public class TipoQuartoService {
	
	@Autowired
	private TipoQuartoRepository _repository;
	
	public BaseResponse inserir(TipoQuartoRequest request) {
		TipoQuartoResponse response = new TipoQuartoResponse();
		TipoQuarto tipo = new TipoQuarto();
		response.statusCode = 400;
		
		if(request.getDescricao() == "") {
			response.message = "Descrição não preenchida";
			return response;
		}
		
		if(request.getValor() == null || request.getValor() == 0) {
			response.message = "Valor não preenchido";
			return response;
		}
		
		tipo.setDescricao(request.getDescricao());
		tipo.setValor(request.getValor());
		
		_repository.save(tipo);
		
		response.setDescricao(tipo.getDescricao());
		response.setValor(tipo.getValor());
		response.statusCode = 201;
		response.message = "Tipo de quarto inserido com sucesso";
		
		return response;
	}
	
	public TipoQuartoResponse obter(Long id) {
		Optional<TipoQuarto> tipo = _repository.findById(id);
		
		TipoQuartoResponse response = new TipoQuartoResponse();
		response.statusCode = 404;
		
		if(tipo.isEmpty()) {
			response.message = "Tipo de Quarto não localizado";
			return response;
		}
		
		response.setId(tipo.get().getId());
		response.setDescricao(tipo.get().getDescricao());
		response.setValor(tipo.get().getValor());
		
		response.statusCode = 200;
		response.message = "Tipo de quarto obtido com sucesso!";
		
		return response;	
	}
	
	public TipoQuartoListResponse listar(){
		List<TipoQuarto> tipos = _repository.findAll();
	
		TipoQuartoListResponse response = new TipoQuartoListResponse();
		response.setTiposQuartos(tipos);
		
		response.statusCode = 200;
		response.message = "Tipos de Quartos obtidos com sucesso";
		return response;
	}
	
//	public BaseResponse atualizar(Long id,TipoQuartoRequest request) {
//		TipoQuarto tipo = new TipoQuarto();
//		BaseResponse response = new BaseResponse();
//		response.statusCode = 400;
//		
//		if(request.getDescricao() == "") {
//			response.message = "Descrição do quarto não preenchido";
//			return response;
//		}
//		
//		if(request.getValor() == null || request.getValor() == 0) {
//			response.message = "Valor do quarto não informado";
//			return response;
//		}
//		
//		tipo.setId(id);
//		tipo.setDescricao(request.getDescricao());
//		tipo.setValor(request.getValor());
//		
//		_repository.save(tipo);
//		
//		response.statusCode = 200;
//		response.message = "Tipo de Quarto atualizado com sucesso!";
//		return response;
//	}
//	
//	public BaseResponse deletar(Long id) {
//		BaseResponse response = new BaseResponse();
//		response.statusCode = 400;
//		
//		if(id == null || id == 0) {
//			response.message = "Tipo de Quarto não localizado!";
//			return response;
//		}
//		
//		_repository.deleteById(id);
//		
//		response.statusCode = 200;
//		response.message = "Tipo de Quarto deletado com sucesso!";
//		return response;
//	}

}
