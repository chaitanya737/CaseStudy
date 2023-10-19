package com.fis.accountmanagement.repo;

import java.util.ArrayList;
import java.util.HashMap;

import com.fis.accountmanagement.beans.Transactions;

//Implementation of TransServiceRepo using HashMap

public class TransServiceRepoImpl implements TransServiceRepo{

	//Initializing of HashMap
	
	HashMap<Long, Transactions> clientAccTransactions = new HashMap<Long, Transactions>();
	
	//Array to Store Account Transactions
	
	ArrayList<String> allTrans = new ArrayList<String>();
	
	@Override
	public String addTransactionNEFT(long transFromAcc, long neftAccNo, Transactions transaction) {
		
		clientAccTransactions.put(transFromAcc, transaction);
		clientAccTransactions.put(neftAccNo, transaction);
		
		System.out.println("Successfully transferred from " + transFromAcc + " to " + neftAccNo 
				+ " with TransactionID " + transaction.getTransId());
		
		return "Transaction Added to Account Transaction History";
	}

	@Override
	public ArrayList<String> getTransForAccNo(Transactions transaction, long showTransAccNo) {
		
		while(true) {
			if (transaction.getAccNoFrom() == showTransAccNo) {
				allTrans.add(transaction.toString());
			}
			if (transaction.getAccNoTo() == showTransAccNo) {
				allTrans.add(transaction.toString());
			}
			return allTrans;
		}
	}

}
