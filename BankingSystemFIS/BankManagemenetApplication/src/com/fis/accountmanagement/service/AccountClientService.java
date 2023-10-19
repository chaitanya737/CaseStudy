package com.fis.accountmanagement.service;

import com.fis.accountmanagement.beans.Accounts;
import com.fis.accountmanagement.exceptions.AccountNotFound;
import com.fis.accountmanagement.exceptions.NotEnoughBalance;

public interface AccountClientService {
	//Adding an Account
	public abstract String addAccount(Accounts account);
	//If Account is not found
	public abstract Accounts getAccount(long getAcc) throws AccountNotFound;
	//If Balance is less
	public abstract void withdrawFromBalance(long getAcc, double withdrawAmount) throws NotEnoughBalance;
	//Deposit in Account.
	public abstract void depositIntoBalance(long getAcc, double depositAmount);
	

}
