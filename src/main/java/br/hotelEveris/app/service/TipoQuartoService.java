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
		if(request.getDescricao() == "") {
			return new BaseResponse(400, "Insira o nome  do quarto");
		}
		
		if(request.getValor() == null || request.getValor() <= 0) {
			return new BaseResponse(400, "Insira o valor  do quarto");
		}
		
		TipoQuarto tipo = new TipoQuarto(
				request.getDescricao(),
				request.getValor()
				);
		
		
		_repository.save(tipo);
		
		return new BaseResponse(201, "Tipo de quarto inserido com sucesso");
	}
	
	public TipoQuartoResponse obter(Long id) {
		Optional<TipoQuarto> tipo = _repository.findById(id);
		
		if(tipo.isEmpty()) {
			return new TipoQuartoResponse(400, "Tipo de quarto não localizado");
		}
		
		return new TipoQuartoResponse(
				200, "Tipo de Quarto obtido com sucesso",
				tipo.get().getId(),
				tipo.get().getDescricao(),
				tipo.get().getValor()
				);
	}
	
	public TipoQuartoListResponse listar(){
		List<TipoQuarto> tipos = _repository.findAll();
		
		if(tipos.isEmpty()) {
			return new TipoQuartoListResponse(400, "Nenhum tipo de quarto localizado");
		}
		
		return new TipoQuartoListResponse(
				200, "Tipos de quartos obtidos com sucesso",
				tipos
				);
	}
}
