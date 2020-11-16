package br.hotelEveris.app.controller;

import br.hotelEveris.app.response.BaseResponse;

public class BaseController {
	
	public BaseResponse errorBase = new BaseResponse(500, "Erro");
	
	public BaseController() {
		errorBase.statusCode = 500;
		errorBase.message = "Um erro inesperado aconteceu, contate o ADM";
	}

}
