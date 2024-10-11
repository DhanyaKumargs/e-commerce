package com.example.e_commerce.exception;

public class ProductExceptin extends RuntimeException {

	private String message;

	public ProductExceptin(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
