package com.fis.accountmanagement.service;

import java.util.ArrayList;

import com.fis.accountmanagement.beans.Transactions;

public interface TransService {
	public abstract String addTransactionNEFT(long transFromAcc, long neftAccNo, Transactions transaction);
	
	public abstract ArrayList<String> getTransForAccNo(Transactions transaction, long showTransAccNo);
}
