package com.fis.accountmanagement.exceptions;


//Exception Class if Balance is Not Sufficient

public class NotEnoughBalance extends Exception {
	public NotEnoughBalance(String message) {
		super(message);
	}
}
