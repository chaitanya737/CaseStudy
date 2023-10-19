package com.fis.accountmanagement.beans;

import java.util.Date;

//Class for representing the Bank Transactions with its various attributes.

public class Transactions {
	
	//Member Variables of the class
	
	private int transId;
	private long accNoFrom;
	private long accNoTo;
	private double amount;
	private Date dateOfTrans;
	String transType;
	double balance;
	
	public Transactions(int transId, long accNoFrom, long accNoTo, double amount, Date dateOfTrans, String transType,
			double balance) {
		
		//Constructor for Initialization
		
		
		super();
		this.transId = transId;
		this.accNoFrom = accNoFrom;
		this.accNoTo = accNoTo;
		this.amount = amount;
		this.dateOfTrans = dateOfTrans;
		this.transType = transType;
		this.balance = balance;
	}

	//Default Constructor
	
	public Transactions() {
	}

	@Override
	
	//String that represents the Transaction Details.
	
	public String toString() {
		return "[Transaction ID = " + transId + ", Account Number From = " + accNoFrom + ", Account Number To = " + accNoTo + ", Amount = "
				+ amount + ", Date Of Transaction = " + dateOfTrans + ", Transaction Type = " + transType + ", Balance = " + balance + "]";
	}
	
	/**
	 * @return the transId
	 */
	

	
	public int getTransId() {
		return transId;
	}
	/**
	 * @param transId the transId to set
	 */
	public void setTransId(int transId) {
		this.transId = transId;
	}
	/**
	 * @return the accNoFrom
	 */
	

	
	public long getAccNoFrom() {
		return accNoFrom;
	}
	/**
	 * @param accNoFrom the accNoFrom to set
	 */
	public void setAccNoFrom(long accNoFrom) {
		this.accNoFrom = accNoFrom;
	}
	/**
	 * @return the accNoTo
	 */
	

	
	public long getAccNoTo() {
		return accNoTo;
	}
	/**
	 * @param accNoTo the accNoTo to set
	 */
	public void setAccNoTo(long accNoTo) {
		this.accNoTo = accNoTo;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the dateOfTrans
	 */
	public Date getDateOfTrans() {
		return dateOfTrans;
	}
	/**
	 * @param dateOfTrans the dateOfTrans to set
	 */
	public void setDateOfTrans(Date dateOfTrans) {
		this.dateOfTrans = dateOfTrans;
	}
	/**
	 * @return the transType
	 */
	public String getTransType() {
		return transType;
	}
	/**
	 * @param transType the transType to set
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
