package br.hotelEveris.app.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hotelEveris.app.model.Cliente;
import br.hotelEveris.app.model.Ocupacao;
import br.hotelEveris.app.model.Quarto;
import br.hotelEveris.app.repository.OcupacaoRepository;
import br.hotelEveris.app.request.OcupacaoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.OcupacaoListResponse;
import br.hotelEveris.app.service.OcupacaoService;

@Service
public class OcupacaoServiceImp implements OcupacaoService {
	
	@Autowired
	private OcupacaoRepository _repository;
	
	public BaseResponse inserir(OcupacaoRequest request){
		
		if(request.getQtdDias() <= 0) {
			return new BaseResponse(400, "Informe a quantidade de dias de ocupacao");
		}
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
		
		if(request.getClienteId() == null) {
			return new BaseResponse(400, "Cliente não pode ser nulo");
		}
		
		if(request.getClienteId() <=0) {
			return new BaseResponse(400, "Informe um cliente válido");
		}
		
		if(request.getQuartoId() == null) {
			return new BaseResponse(400, "Informe o quarto");
		}
		
		if(request.getQuartoId() <= 0) {
			return new BaseResponse(400, "Informe o quarto");
		}
		
		if(request.getData() == "") {
			return new BaseResponse(400, "Insira a data de hospedagem");
		}
		
		
		Cliente cliente = new Cliente(request.getClienteId());
		
		Quarto quarto = new Quarto(request.getQuartoId());
		
		Ocupacao ocupacao = new Ocupacao(
				request.getData(),
				request.getQtdDias(),
				cliente,
				quarto
				);
		
		_repository.save(ocupacao);
		
		return new BaseResponse(201, "Ocupacao inserida com sucesso!");
	}
	
	public OcupacaoListResponse listar(){
		List <Ocupacao> ocupacoes = _repository.findAll();
		
		return new OcupacaoListResponse(
				200, "Ocupações obtidas com sucesso!",
				ocupacoes
				);
	}

}
