package br.hotelEveris.app.service.imp;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.hotelEveris.app.model.Comodidade;
import br.hotelEveris.app.repository.ComodidadeRepository;
import br.hotelEveris.app.request.ComodidadeRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.ComodidadeResponse;
import br.hotelEveris.app.service.ComodidadeService;

@Service
public class ComodidadeServiceImp implements ComodidadeService {
	
	@Autowired
	private ComodidadeRepository _repository;
	
	public BaseResponse inserir(ComodidadeRequest request) {		
		if(request.getNome() == "" || request.getNome() == null ) {
			return new BaseResponse(400, "Erro, Preencha o nome da comodidade");
		}
		
		Comodidade comodidade = new Comodidade(
				request.getNome()
				);
		
		_repository.save(comodidade);
		
		return new BaseResponse(201, "Comodidade inserida com sucesso!");
	}
	
	public ComodidadeResponse obter(Long id) {
		Optional<Comodidade> comodidade = _repository.findById(id);
		
		if(comodidade.isEmpty()) {
			return new ComodidadeResponse(400, "Comodidade não localizada");
		}
		
		if(id <= 0) {
			return new ComodidadeResponse(400, "Comodidade não existe");
		}
		
		return new ComodidadeResponse(
				200,
				"Cliente obtido com sucesso",
				comodidade.get().getId(),
				comodidade.get().getNome()
				);
	}
}
