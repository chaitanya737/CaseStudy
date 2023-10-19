package com.fis.accountmanagement.repo;

import com.fis.accountmanagement.beans.Accounts;
import com.fis.accountmanagement.exceptions.AccountNotFound;
import com.fis.accountmanagement.exceptions.NotEnoughBalance;

//This is an Interface that is used for Interacting with account data

public interface AccountClientRepo {
	
	//Method to Add Account
	
	public abstract String addAccount(Accounts account);
	
	//Method to get account from account number

	public abstract Accounts getAccount(long getAcc) throws AccountNotFound;
	
	//Method to withdraw from Balance
	
	public abstract void withdrawFromBalance(long getAcc, double withdrawAmount) throws NotEnoughBalance;
	
	//Method for Depositing in Bank Account.

	public abstract void depositIntoBalance(long getAcc, double depositAmount);
}
