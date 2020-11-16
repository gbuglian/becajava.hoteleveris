package br.hotelEveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hotelEveris.app.request.QuartoPatchRequest;
import br.hotelEveris.app.request.QuartoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.QuartoResponse;
import br.hotelEveris.app.service.QuartoService;

@RestController
@RequestMapping("/quartos")
public class QuartoController extends BaseController {

	@Autowired
	private QuartoService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody QuartoRequest request) {
		try {
			BaseResponse response = service.inserir(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		try {
			QuartoResponse response = service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping(path = "/tipo-quarto/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		try {
			BaseResponse response = service.listar(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	
	@PatchMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> atualizar(@PathVariable Long id,
			@Validated @RequestBody QuartoPatchRequest request) {
		try {
			BaseResponse response = service.atualizar(id, request);
			return ResponseEntity.status(response.statusCode).body(response);

		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}

	}

}
