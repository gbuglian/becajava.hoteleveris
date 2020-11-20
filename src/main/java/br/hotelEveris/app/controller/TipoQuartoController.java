package br.hotelEveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hotelEveris.app.request.TipoQuartoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.TipoQuartoResponse;
import br.hotelEveris.app.service.TipoQuartoService;

@RestController
@RequestMapping("/TiposQuartos")
public class TipoQuartoController extends BaseController {

	@Autowired
	private TipoQuartoService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody TipoQuartoRequest request) {
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
			TipoQuartoResponse response = service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			BaseResponse response = service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

//	@PutMapping(path = "/{id}")
//	public ResponseEntity atualizar(@RequestBody TipoQuartoRequest request, @PathVariable Long id) {
//		try {
//			BaseResponse response = service.atualizar(id, request);
//			return ResponseEntity.status(response.statusCode).body(response);
//		} catch (Exception e) {
//			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
//		}
//	}
//	
//	@DeleteMapping(path = "/{id}")
//	public ResponseEntity deletar(@PathVariable Long id) {
//		try {
//			BaseResponse response = service.deletar(id);
//			return ResponseEntity.status(response.statusCode).body(response);
//		}catch(Exception e) {
//			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
//		}
//	}

}
