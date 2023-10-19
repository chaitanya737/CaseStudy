package com.fis.accountmanagement.exceptions;


//Exception Class If Account is Not Found 

public class AccountNotFound extends Exception{
	private static final long serialVersionUID = 1L;
	public AccountNotFound(String message) {
		super(message);
	}
}
