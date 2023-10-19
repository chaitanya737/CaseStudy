package com.fis.accountmanagement.repo;

import java.util.ArrayList;

import com.fis.accountmanagement.beans.Transactions;

//Interface that Defines methods for interaction with the transaction Data

public interface TransServiceRepo {
	
	//Method to Add a Transaction
	
	public abstract String addTransactionNEFT(long transFromAcc, long neftAccNo, Transactions transaction);
	
	//Method to get the Transaction Information using the Account Number
	
	public abstract ArrayList<String> getTransForAccNo(Transactions transaction, long showTransAccNo);

}
