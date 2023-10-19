package com.fis.accountmanagement.service;

import java.util.ArrayList;

import com.fis.accountmanagement.beans.Transactions;
import com.fis.accountmanagement.repo.TransServiceRepo;
import com.fis.accountmanagement.repo.TransServiceRepoImpl;

public class TransServiceImpl implements TransService {
	TransServiceRepo dao = new TransServiceRepoImpl();

	@Override
	public String addTransactionNEFT(long transFromAcc, long neftAccNo, Transactions transaction) {
		return dao.addTransactionNEFT(transFromAcc, neftAccNo, transaction);
	}

	@Override
	public ArrayList<String> getTransForAccNo(Transactions transaction, long showTransAccNo) {
		return dao.getTransForAccNo(transaction, showTransAccNo);
	}

}
