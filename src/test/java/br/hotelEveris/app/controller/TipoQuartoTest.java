package br.hotelEveris.app.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hotelEveris.app.request.TipoQuartoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.TipoQuartoListResponse;
import br.hotelEveris.app.response.TipoQuartoResponse;
import br.hotelEveris.app.service.TipoQuartoService;

@SpringBootTest
public class TipoQuartoTest {
	
	@Autowired
	private TipoQuartoService service;
	

	@Test
	public void inserir() {
		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setDescricao("Testando");
		request.setValor(1010.20);
		
		BaseResponse response = service.inserir(request);
	
		Assertions.assertEquals(201, response.getStatusCode());
		Assertions.assertEquals("Tipo de quarto inserido com sucesso", response.getMessage());
	}
	@Test
	public void inserirSemDescricao() {
		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setDescricao("");
		request.setValor(1010.20);
		
		BaseResponse response = service.inserir(request);
	
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Insira a descrição do quarto", response.getMessage());
	}
	@Test
	public void inserirSemValor() {
		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setDescricao("Testando");
		request.setValor(-00.0);
		
		BaseResponse response = service.inserir(request);
	
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Insira o valor  do quarto", response.getMessage());
	}
	
	@Test
	public void inserirValorNulo() {
		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setDescricao("Testando");
		request.setValor(null);
		
		BaseResponse response = service.inserir(request);
	
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Insira o valor  do quarto", response.getMessage());
	}
	
	@Test
	public void obter() {
		Long id = 1L;
		
		TipoQuartoResponse response = service.obter(id);
		
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Tipo de Quarto obtido com sucesso", response.getMessage());
	}
	@Test
	public void obterIdInexistente() {
		Long id = 90L;
		
		TipoQuartoResponse response = service.obter(id);
		
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Tipo de quarto não localizado", response.getMessage());
	}
	@Test
	public void obterIdMenorIgualZero() {
		Long id = 0L;
		
		TipoQuartoResponse response = service.obter(id);
		
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Tipo de quarto não localizado", response.getMessage());
	}
	
	@Test
	public void listar() {
		 TipoQuartoListResponse response = service.listar();
		 
		response.setTiposQuartos(response.getTiposQuartos());
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Tipos de quartos obtidos com sucesso", response.getMessage());
	}

}

