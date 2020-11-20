package br.hotelEveris.app.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hotelEveris.app.request.ComodidadeRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.ComodidadeResponse;
import br.hotelEveris.app.service.imp.ComodidadeServiceImp;

@SpringBootTest
public class ComodidadeTest {

	@Autowired
	private ComodidadeServiceImp service;
	
	@Test
	public void inserir() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome("SERVIÇO");
		
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(201, response.getStatusCode());
	}
	
	@Test 
	public void inserirVazio() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome("");
		
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirNulo() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome(null);
		
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	
	}
	
	@Test
	public void obter() {
		Long id = 14L;
		ComodidadeResponse response = service.obter(id);
		Assertions.assertEquals(200, response.getStatusCode());
	}
	
	@Test
	public void ObterIgualAZero() {
		Long id = 0L;
		ComodidadeResponse response = service.obter(id);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void ObterMenorQueZero() {
		Long id = -1L;
		ComodidadeResponse response = service.obter(id);
		Assertions.assertEquals(400, response.getStatusCode());
	}
}
