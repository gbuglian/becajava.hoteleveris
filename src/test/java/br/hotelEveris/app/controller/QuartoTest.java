package br.hotelEveris.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hotelEveris.app.request.ComodidadeRequest;
import br.hotelEveris.app.request.QuartoPatchRequest;
import br.hotelEveris.app.request.QuartoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.QuartoListResponse;
import br.hotelEveris.app.response.QuartoResponse;
import br.hotelEveris.app.service.QuartoService;

@SpringBootTest
public class QuartoTest {
	
	@Autowired
	private QuartoService service;
	
	@Test
	public void inserir() {
		QuartoRequest request =  new QuartoRequest();
		request.setAndar(32);
		
		List<ComodidadeRequest> lista = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		lista.add(comodidade);
		
		request.setComodidades(lista);
		request.setTipoQuartoId(1L);
		int numQuarto = this.getRandomNumberUsingInts(1,1000);
		request.setNumQuarto(numQuarto);
		request.setSituacao("A");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(201, response.getStatusCode());
		Assertions.assertEquals("Quarto inserido com sucesso!", response.getMessage());
		
	}

	
	@Test
	public void inserirSemNumQuarto() {
		QuartoRequest request =  new QuartoRequest();
		request.setAndar(32);
		
		List<ComodidadeRequest> lista = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		lista.add(comodidade);
		
		request.setComodidades(lista);
		request.setTipoQuartoId(1L);
//		int numQuarto = this.getRandomNumberUsingInts(1,1000);
//		request.setNumQuarto(numQuarto);
		request.setSituacao("A");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Preencha o número do quarto", response.getMessage());
		
	}
	
	@Test
	public void inserirSemAndar() {
		QuartoRequest request =  new QuartoRequest();
//		request.setAndar(32);
		
		List<ComodidadeRequest> lista = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		lista.add(comodidade);
		
		request.setComodidades(lista);
		request.setTipoQuartoId(1L);
		int numQuarto = this.getRandomNumberUsingInts(1,1000);
		request.setNumQuarto(numQuarto);
		request.setSituacao("A");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Preencha o andar", response.getMessage());	
	}
	
	@Test
	public void inserirSemSituacao() {
		QuartoRequest request =  new QuartoRequest();
		request.setAndar(32);
		
		List<ComodidadeRequest> lista = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		lista.add(comodidade);
		
		request.setComodidades(lista);
		request.setTipoQuartoId(1L);
		int numQuarto = this.getRandomNumberUsingInts(1,1000);
		request.setNumQuarto(numQuarto);
		request.setSituacao("");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Preencha a situação do quarto", response.getMessage());	
	}
	
	@Test
	public void inserirTipoQuartoIgualAZero() {
		QuartoRequest request =  new QuartoRequest();
		request.setAndar(32);
		
		List<ComodidadeRequest> lista = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		lista.add(comodidade);
		
		request.setComodidades(lista);
		request.setTipoQuartoId(0L);
		int numQuarto = this.getRandomNumberUsingInts(1,1000);
		request.setNumQuarto(numQuarto);
		request.setSituacao("A");
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Preencha o tipo de quarto", response.getMessage());	
	}
	
	public int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
          .findFirst()
          .getAsInt();
    }
	
	@Test
	public void obter() {
		Long id = 1L;
		QuartoResponse response = service.obter(id);
		
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Quarto obtido com sucesso!", response.getMessage());
		
	}
	@Test
	public void obterIdInexistente() {
		Long id = 178L;
		QuartoResponse response = service.obter(id);
		
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Quarto não localizado", response.getMessage());
	}
	@Test
	public void obterIdIMenorQueZero() {
		Long id = -1L;
		QuartoResponse response = service.obter(id);
		
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Quarto não existente", response.getMessage());
	}
	
	@Test
	public void listarQuartoPorTipoQuartoId() {
		Long id = 1L;
		QuartoListResponse response = service.listar(id);
		
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Quartos obtidos com sucesso!", response.getMessage());
		
	}
	@Test
	public void listarQuartoPorTipoQuartoIdInexistente() {
		Long id = 22L;
		QuartoListResponse response = service.listar(id);
		
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Nenhum Quarto Localizado", response.getMessage());
		
	}
	
	@Test
	public void atualizarSituacao() {
		QuartoPatchRequest request = new QuartoPatchRequest();
		request.setSituacao("A");
		
		Long id = 1L;	
		BaseResponse response = service.atualizar(id, request);
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Atualizado com sucesso", response.getMessage());
		
		
	}
	@Test
	public void atualizarSituacaoIdInexistente() {
		QuartoPatchRequest request = new QuartoPatchRequest();
		request.setSituacao("I");
		
		Long id = 58L;	
		BaseResponse response = service.atualizar(id, request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Id inválido", response.getMessage());
		
	}
	
	@Test
	public void atualizarSituacaoIdMenorQueZero() {
		QuartoPatchRequest request = new QuartoPatchRequest();
		request.setSituacao("A");
		
		Long id = -1L;	
		BaseResponse response = service.atualizar(id, request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Id inválido", response.getMessage());
		
	}
	
	@Test
	public void atualizarSituacaoInvalida() {
		QuartoPatchRequest request = new QuartoPatchRequest();
		request.setSituacao(null);
		
		Long id = 13L;	
		BaseResponse response = service.atualizar(id, request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Situação não informada", response.getMessage());
		
		
	}
	
	
	
	

}
