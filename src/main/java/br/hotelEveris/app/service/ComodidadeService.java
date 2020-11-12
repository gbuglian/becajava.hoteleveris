package br.hotelEveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hotelEveris.app.model.Comodidade;
import br.hotelEveris.app.repository.ComodidadeRepository;
import br.hotelEveris.app.request.ComodidadeRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.ComodidadeListResponse;
import br.hotelEveris.app.response.ComodidadeResponse;

@Service
public class ComodidadeService {
	
	@Autowired
	private ComodidadeRepository _repository;
	
	public BaseResponse inserir(ComodidadeRequest request) {
		ComodidadeResponse response = new ComodidadeResponse();
		Comodidade comodidade = new Comodidade();
		response.statusCode = 400;
		
		if(request.getNome() == "" || request.getNome() == null ) {
			response.message = "Comodidade não informada";
			return response;
		}
		
		comodidade.setNome(request.getNome());
		
		_repository.save(comodidade);
		
		response.setNome(comodidade.getNome());
		response.setId(comodidade.getId());
		response.statusCode = 201;
		response.message = "Comodidade inserida com sucesso!";
		
		return response;
	}
	
	public ComodidadeResponse obter(Long id) {
		Optional<Comodidade> comodidade = _repository.findById(id);
		ComodidadeResponse response = new ComodidadeResponse();
		response.statusCode = 400;
		
		if(comodidade.isEmpty()) {
			response.message = "Comodidade não localizada";
			return response;
		}
		
		response.setId(comodidade.get().getId());
		response.setNome(comodidade.get().getNome());
		response.statusCode = 200;
		response.message = "Comodidade obtida com sucesso!";
		
		return response;
	}
	
	public ComodidadeListResponse listar() {
		List <Comodidade> list = _repository.findAll();
		
		ComodidadeListResponse response = new ComodidadeListResponse();
		response.setComodidades(list);
		
		response.statusCode = 200;
		response.message = "Comodidades Obtidas com sucesso!";
		
		return response;
	}

}
