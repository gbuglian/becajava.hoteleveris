package br.hotelEveris.app.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hotelEveris.app.request.OcupacaoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.OcupacaoListResponse;
import br.hotelEveris.app.service.imp.OcupacaoServiceImp;

@SpringBootTest	
public class OcupacaoTest {
	
	@Autowired
	private OcupacaoServiceImp service;
	
	@Test
	public void inserir() {
		
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(30L);
		request.setClienteId(29L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(201, response.getStatusCode());
		Assertions.assertEquals("Ocupacao inserida com sucesso!", response.getMessage());
	}
	
	@Test
	public void inserirSemData() {
		OcupacaoRequest request = new OcupacaoRequest();
//		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(30L);
		request.setClienteId(29L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Insira a data de hospedagem", response.getMessage());
	}
	
	@Test
	public void inserirQntdDiasIgualaZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(0);
		request.setQuartoId(30L);
		request.setClienteId(29L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Informe a quantidade de dias de ocupacao", response.getMessage());
	}
	
	@Test
	public void inserirQntdDiasMenorQueZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(-1);
		request.setQuartoId(30L);
		request.setClienteId(29L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Informe a quantidade de dias de ocupacao", response.getMessage());

	}
	
	@Test
	public void inserirSemClienteId() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(2);
		request.setQuartoId(30L);
//		request.setClienteId(1L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Informe um cliente válido", response.getMessage());

	}
	
	@Test
	public void inserirClienteIdNull() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(30L);
		request.setClienteId(null);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Informe um cliente válido", response.getMessage());

	}
	
	@Test
	public void inserirClienteIgualAZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(4);
		request.setQuartoId(30L);
		request.setClienteId(0L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Informe um cliente válido", response.getMessage());

	}
	
	@Test
	public void inserirClienteMenorQueZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(5);
		request.setQuartoId(30L);
		request.setClienteId(-1L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Informe um cliente válido", response.getMessage());

	}
	
	@Test
	public void inserirSemQuartoId() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
//		request.setQuartoId(1L);
		request.setClienteId(29L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirQuartoIdNull() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(null);
		request.setClienteId(29L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirQuartoIdIgualAZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(0L);
		request.setClienteId(29L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirQuartoIdMenorQueZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(-1L);
		request.setClienteId(29L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
    public void Listar() {
    OcupacaoListResponse Ocupacaoresponse = new OcupacaoListResponse();
    Ocupacaoresponse.setOcupacoes(Ocupacaoresponse.getOcupacoes());

    BaseResponse response = service.listar();
    Assertions.assertEquals(200,response.statusCode);

	}
	
}
