package com.fis.accountmanagement.beans;



//Class for the representation of a Bank Account

public class Accounts {
	
	//Variables that represent a Account
	
	
	private long accNo;
	private String custName;
	private long mobile;
	private String accType;
	private String branch;
	private double balance;
//	private List<Transactions> transaction;
	@Override
	
	//This String will be displayed showing all the details of the account.
	
	public String toString() {
		return "[Account Number=" + accNo + ", Customer Name=" + custName + ", Mobile=" + mobile + ", Account Type=" + accType
				+ ", Branch=" + branch + ", Balance=" + balance + "]";
	}
	
	//Constructor for initializing account.
	
	public Accounts(long accNo, String custName, long mobile, String accType, String branch, double balance) {
		//Initializing all the member variables that represent the account
		super();
		this.accNo = accNo;
		this.custName = custName;
		this.mobile = mobile;
		this.accType = accType;
		this.branch = branch;
		this.balance = balance;
	}
	
	//Default Constructor
	
	public Accounts() {
	}
	/**
	 * @return the accNo
	 */
	
	//Function to get the Ac No.
	
	public long getAccNo() {
		return accNo;
	}
	/**
	 * @param accNo the accNo to set
	 */
	
	//Setting the Ac no
	
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	/**
	 * @return the custName
	 */
	
	//Getting the Customer name
	
	public String getCustName() {
		return custName;
	}
	/**
	 * @param custName the custName to set
	 */
	
	//Set Customer Name
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * @return the mobile
	 */
	
	//Getting Mobile No.
	
	public long getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	
	//Setting Mobile No
	
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the accType
	 */
	
	//Get Account Type
	
	public String getAccType() {
		return accType;
	}
	/**
	 * @param accType the accType to set
	 */
	
	//Set Acc Type
	
	public void setAccType(String accType) {
		this.accType = accType;
	}
	/**
	 * @return the branch
	 */
	
	//Getting the Branch
	
	public String getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	
	//Setting the Branch
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * @return the balance
	 */
	
	//Getting the Account Balance.
	
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	
	//Setting the Account Balance
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
