package com.fis.accountmanagement.service;

import com.fis.accountmanagement.beans.Accounts;
import com.fis.accountmanagement.exceptions.AccountNotFound;
import com.fis.accountmanagement.exceptions.NotEnoughBalance;
import com.fis.accountmanagement.repo.AccountClientRepo;
import com.fis.accountmanagement.repo.AccountClientRepoImpl;

public class AccountClientServiceImpl implements AccountClientService {
	AccountClientRepo dao = new AccountClientRepoImpl();

	@Override
	public String addAccount(Accounts account) {
		return dao.addAccount(account);

	}

	@Override
	public Accounts getAccount(long getAcc) throws AccountNotFound {
		return dao.getAccount(getAcc);

	}

	@Override
	public void withdrawFromBalance(long getAcc, double withdrawAmount) throws NotEnoughBalance {
		
		dao.withdrawFromBalance(getAcc, withdrawAmount);
	}
	
	@Override
	public void depositIntoBalance(long getAcc, double depositAmount) {
		
		dao.depositIntoBalance(getAcc, depositAmount);
	}


}
