package br.hotelEveris.app.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hotelEveris.app.model.Comodidade;
import br.hotelEveris.app.model.Quarto;
import br.hotelEveris.app.model.QuartoComodidade;
import br.hotelEveris.app.model.TipoQuarto;
import br.hotelEveris.app.repository.QuartoComodidadeRepository;
import br.hotelEveris.app.repository.QuartoRepository;
import br.hotelEveris.app.request.ComodidadeRequest;
import br.hotelEveris.app.request.QuartoPatchRequest;
import br.hotelEveris.app.request.QuartoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.QuartoListResponse;
import br.hotelEveris.app.response.QuartoResponse;
import br.hotelEveris.app.service.QuartoService;

@Service
public class QuartoServiceImp implements QuartoService {

	@Autowired
	private QuartoRepository _repository;

	@Autowired
	private QuartoComodidadeRepository quartoComodidadeRepository;

	public BaseResponse inserir(QuartoRequest request) {

		if (request.getNumQuarto() <= 0) {
			return new BaseResponse(400, "Preencha o número do quarto");
		}

		if (request.getAndar() <= 0) {
			return new BaseResponse(400, "Preencha o andar");
		}

		if (request.getSituacao() == "") {
			return new BaseResponse(400, "Preencha a situação do quarto, Preencha A se estiver Ativo, ou Preencha I se estiver inativo");
		}
		
		if(request.getTipoQuartoId() <= 0) {
			return new BaseResponse(400, "Preencha o tipo de quarto");
		}
		
//		if(request.getComodidades() == null) {
//			return new BaseResponse(400, "Preencha a comodidade");
//		}

		TipoQuarto tipoQuarto = new TipoQuarto(request.getTipoQuartoId());

		Quarto quarto = new Quarto(
				request.getNumQuarto(), 
				request.getAndar(), 
				request.getSituacao(), 
				tipoQuarto
				);

		_repository.save(quarto);

		Long idQuarto = _repository.findByNumQuarto(request.getNumQuarto()).get().getId();

		for (ComodidadeRequest item : request.getComodidades()) {
			QuartoComodidade quartoComodidade = new QuartoComodidade(
					new Quarto(idQuarto),
					new Comodidade(item.getId())
					);

			quartoComodidadeRepository.save(quartoComodidade);
		}

		return new BaseResponse(201, "Quarto inserido com sucesso!");
	}
	
	public QuartoResponse obter(Long id) {
		Optional<Quarto> quarto = _repository.findById(id);
		
	
		if(quarto.isEmpty()) {
			return new QuartoResponse(400, "Quarto não localizado");
		}
		
		if(id <= 0) {
			return new QuartoResponse(400, "Quarto não existente");
		}
		
		return new QuartoResponse(
				200, "Quarto obtido com sucesso!", 
				quarto.get().getId(), 
				quarto.get().getAndar(),
				quarto.get().getNumQuarto(), 
				quarto.get().getSituacao(),
				quarto.get().getTipoQuarto()
				);
	}
	
	public QuartoListResponse listar(Long id) {
		List <Quarto> quartos = _repository.findByTipoQuartos(id);
		
		if(quartos.isEmpty()) {
			return new QuartoListResponse(400, "Nenhum Quarto Localizado");
		}
		
		return new QuartoListResponse(
				200, "Quartos obtidos com sucesso!",
				quartos
				);
	}
	
	public BaseResponse atualizar(Long id,QuartoPatchRequest request) {
		Optional<Quarto> quarto = _repository.findById(id);
		
		if(id <= 0 || quarto.isEmpty()) {
			return new BaseResponse(400, "Id inválido");
		}
		
		if(request.getSituacao() == null || request.getSituacao() == ""){
			return new BaseResponse(400, "Situação não informada");
		}		
		
		quarto.get().setSituacao(request.getSituacao());
		
		_repository.save(quarto.get());
		
		return new BaseResponse(
				200, "Atualizado com sucesso"
				);
		
	}

}
