package br.hotelEveris.app.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hotelEveris.app.response.BaseResponse;
import br.hotelEveris.app.service.FaturaService;

@SpringBootTest
public class FaturaTest {
	
	@Autowired
	private FaturaService service;
	
	@Test
	public void Transferencia() {
		BaseResponse response = service.transferencia();
		
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Transferencia realizada com sucesso", response.getMessage());
		
	}
		
}