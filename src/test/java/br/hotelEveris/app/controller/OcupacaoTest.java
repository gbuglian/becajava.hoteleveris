package br.hotelEveris.app.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hotelEveris.app.request.OcupacaoRequest;
import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.response.OcupacaoListResponse;
import br.hotelEveris.app.service.OcupacaoService;

@SpringBootTest	
public class OcupacaoTest {
	
	@Autowired
	private OcupacaoService service;
	
	@Test
	public void inserir() {
		
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(1L);
		request.setClienteId(1L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(201, response.getStatusCode());
	}
	
	@Test
	public void inserirSemData() {
		OcupacaoRequest request = new OcupacaoRequest();
//		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(1L);
		request.setClienteId(1L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirQntdDiasIgualaZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(0);
		request.setQuartoId(1L);
		request.setClienteId(1L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirQntdDiasMenorQueZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(-1);
		request.setQuartoId(1L);
		request.setClienteId(1L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirSemClienteId() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(2);
		request.setQuartoId(1L);
//		request.setClienteId(1L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirClienteIdNull() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(1L);
		request.setClienteId(null);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirClienteIgualAZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(4);
		request.setQuartoId(1L);
		request.setClienteId(0L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirClienteMenorQueZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(5);
		request.setQuartoId(1L);
		request.setClienteId(-1L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirSemQuartoId() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
//		request.setQuartoId(1L);
		request.setClienteId(2L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirQuartoIdNull() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(null);
		request.setClienteId(2L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirQuartoIdIgualAZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(0L);
		request.setClienteId(2L);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void inserirQuartoIdMenorQueZero() {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("2020-12-11");
		request.setQtdDias(3);
		request.setQuartoId(-1L);
		request.setClienteId(2L);
		
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
