package br.hotelEveris.app.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hotelEveris.app.request.ClienteRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.ClienteResponse;
import br.hotelEveris.app.service.imp.ClienteServiceImp;

@SpringBootTest
public class ClienteTest {

	@Autowired
	private ClienteServiceImp service;
	
	@Test
	public void inserir() {
		ClienteRequest request = new ClienteRequest();
		request.setCpf("856632");
		request.setHash("testefinal");
		request.setNome("Gabriel");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(201, response.getStatusCode());
		Assertions.assertEquals("Cliente inserido com sucesso!", response.getMessage());
		
		}
	
	@Test
	public void inserirSemCpf() {
		ClienteRequest request = new ClienteRequest();
		request.setHash("h32382");
		request.setNome("Gabriel");
		request.setCpf("");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Erro, Preencha o CPF", response.getMessage());
		
	}
	
	@Test
	public void inserirCpfNulo() {
		ClienteRequest request = new ClienteRequest();
		request.setHash("h32382");
		request.setNome("Gabriel");
		request.setCpf(null);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Erro, Preencha o CPF", response.getMessage());
		
	}
	
	@Test
	public void inserirSemHash() {
		ClienteRequest request = new ClienteRequest();
		request.setCpf("5038685");
		request.setHash("");
		request.setNome("Gabriel");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Erro, Preencha o Hash", response.getMessage());
		
	}
	
	@Test
	public void inserirHashNulo() {
		ClienteRequest request = new ClienteRequest();
		request.setCpf("5038685");
		request.setHash(null);
		request.setNome("Gabriel");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Erro, Preencha o Hash", response.getMessage());
		
	}
	
	@Test
	public void inserirSemNome() {
		ClienteRequest request = new ClienteRequest();
		request.setCpf("5038685");
		request.setHash("h32382");
		request.setNome("");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Erro, Preencha o nome", response.getMessage());
		
	}
	
	@Test
	public void inserirNomeNulo() {
		ClienteRequest request = new ClienteRequest();
		request.setCpf("5038685");
		request.setHash("h32382");
		request.setNome(null);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Erro, Preencha o nome", response.getMessage());
		
	}
	
	
	//TESTE DE CLIENTE POR ID
	@Test
	public void obter() {
		Long id = 29L;
		ClienteResponse response = service.obter(id);
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Cliente Obtido com sucesso", response.getMessage());
		
	}
	@Test
	public void obterIdInvalido() {
		Long id = 67L;
		ClienteResponse response = service.obter(id);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Cliente não informado", response.getMessage());
		
	}
	@Test
	public void obterIdMenorIgualAZero() {
		Long id = 0L;
		ClienteResponse response = service.obter(id);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Id Inválido", response.getMessage());
		
		
	}	
}