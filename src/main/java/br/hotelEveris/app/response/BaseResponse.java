package br.hotelEveris.app.response;

import javax.persistence.Transient;

public class BaseResponse {
	
	@Transient
	public int statusCode;
	@Transient
	public String message;
	
	public BaseResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public BaseResponse() {
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
}
