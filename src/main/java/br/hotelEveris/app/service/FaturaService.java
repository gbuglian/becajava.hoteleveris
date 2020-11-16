package br.hotelEveris.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.hotelEveris.app.model.Ocupacao;
import br.hotelEveris.app.repository.ClienteRepository;
import br.hotelEveris.app.repository.OcupacaoRepository;
import br.hotelEveris.app.repository.QuartoRepository;
import br.hotelEveris.app.repository.TipoQuartoRepository;
import br.hotelEveris.app.request.TransferenciaRequest;
import br.hotelEveris.app.response.BaseResponse;

@Service
public class FaturaService {
	
	@Autowired
	private OcupacaoRepository ocupacaoRepository;
	
	private String hashContaHotel = "123456";
	
	public BaseResponse transferencia(){
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/operacao/transferencia";
		
		List<Ocupacao> lista = ocupacaoRepository.findByStatus("N");
		
		for (Ocupacao ocupacao: lista) {
		double valor = ocupacao.getQuarto().getTipoQuarto().getValor() * ocupacao.getQtdDias();
		
		TransferenciaRequest transferenciaRequest = new TransferenciaRequest();
		transferenciaRequest.setHashDestino(hashContaHotel);
		transferenciaRequest.setHashOrigem(ocupacao.getCliente().getHashConta());
		transferenciaRequest.setValor(valor);
		
		restTemplate.postForObject(url, transferenciaRequest, BaseResponse.class);
		
		ocupacao.setStatus("P");
		ocupacaoRepository.save(ocupacao);
		
		}
		
		return new BaseResponse(200, "Transferencia realizada com sucesso");
		
	}
	
	

}