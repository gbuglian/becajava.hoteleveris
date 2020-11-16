package br.hotelEveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hotelEveris.app.request.OcupacaoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.OcupacaoResponse;
import br.hotelEveris.app.service.OcupacaoService;

@RestController
@RequestMapping("/ocupacoes")
public class OcupacaoController extends BaseController {
	
	@Autowired
	private OcupacaoService service;
	
	@PostMapping
	public ResponseEntity inserir(@RequestBody OcupacaoRequest request) {
		try {
			BaseResponse response = service.inserir(request);
			return ResponseEntity.status(response.statusCode).body(response);
		}catch(Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	
	@GetMapping
	public ResponseEntity listar() {
		try {
			BaseResponse response = service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		}catch(Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	

}
