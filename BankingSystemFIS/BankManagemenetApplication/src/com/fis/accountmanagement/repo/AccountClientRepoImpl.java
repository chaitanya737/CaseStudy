package com.fis.accountmanagement.repo;

import java.util.HashMap;

import com.fis.accountmanagement.beans.Accounts;
import com.fis.accountmanagement.exceptions.AccountNotFound;
import com.fis.accountmanagement.exceptions.NotEnoughBalance;

//Class that Implements AccountClientRepo and using HASHMAP

public class AccountClientRepoImpl implements AccountClientRepo {

	//Initializing HashMap to Store Account Details
	HashMap<Long, Accounts> clientAccounts = new HashMap<Long, Accounts>();

	@Override
	
	
	
	public String addAccount(Accounts accounts) {
		// TODO Auto-generated method stub

		clientAccounts.put(accounts.getAccNo(), accounts);

		return "Account Added Successfully!";
	}

	@Override
	

	
	public Accounts getAccount(long getAcc) throws AccountNotFound {
		// TODO Auto-generated method stub
		if (clientAccounts.containsKey(getAcc)) {
			return clientAccounts.get(getAcc);
		} else {
			throw new AccountNotFound("Invalid Account Number");
		}
	}

	@Override
	

	
	public void withdrawFromBalance(long getAcc, double withdrawAmount) throws NotEnoughBalance{

		if (clientAccounts.containsKey(getAcc) && (clientAccounts.get(getAcc).getBalance() - withdrawAmount) > -1) {
			clientAccounts.get(getAcc).setBalance(clientAccounts.get(getAcc).getBalance() - withdrawAmount);
		}
		else {
			throw new NotEnoughBalance("Not enough Balance");
		}
	}
	
	
	
	@Override
	public void depositIntoBalance(long getAcc, double depositAmount) {

		if (clientAccounts.containsKey(getAcc)) {
			clientAccounts.get(getAcc).setBalance(clientAccounts.get(getAcc).getBalance() + depositAmount);
		}
	}

}
