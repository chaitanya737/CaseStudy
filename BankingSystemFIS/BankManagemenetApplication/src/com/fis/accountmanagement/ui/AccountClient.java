package com.fis.accountmanagement.ui;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.fis.accountmanagement.beans.Accounts;
import com.fis.accountmanagement.beans.Transactions;
import com.fis.accountmanagement.exceptions.AccountNotFound;
import com.fis.accountmanagement.exceptions.NotEnoughBalance;
import com.fis.accountmanagement.service.AccountClientService;
import com.fis.accountmanagement.service.AccountClientServiceImpl;
import com.fis.accountmanagement.service.TransService;
import com.fis.accountmanagement.service.TransServiceImpl;

//Main Class for the Account Management System

public class AccountClient {
	
	

	public static void main(String[] args) {

		//Initializing a Scanner for User Input
		
		Scanner sc = new Scanner(System.in);
		
		
		//Initializing Variables for user input and account Management
		
		//Initializing Variables for user input and account Management
		//Initializing the Random Function
		Random random = new Random();
		long accNo = 17876 + random.nextInt(25000);
		
		String custName;//The Customer Name
		
		long mobile;//Customer Mobile
		
		String accType;//Account Type
		String branch;//Branch 
		double balance;//Balance
		int transId = 100;//Transaction ID
		long accNoFrom;//Account No From
		long accNoTo;//To Account Number
		double amount;//Amount
		Date dateOfTrans;//Date of Transaction
		String transType;//Type of Transaction
		
		
		//Creating Instances for Account and Transaction Objects and Initializing them.

		Accounts account = null;
		Transactions transaction = null;
		
		
		//Initialize Services for account and Transaction Management.
		
		AccountClientService service = new AccountClientServiceImpl();
		TransService transService = new TransServiceImpl();

		//Main Loop for the Application.
		
		while (true) {
			System.out.println("-----Bank Managment System-----");
			System.out.println("1. Create new account");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Show customer details");
			System.out.println("5. Fund transfer");
			System.out.println("6. Display Transaction Details");
			System.out.println("7. Exit application");
			int choice = sc.nextInt();
			
			//Taking the Inpuy of the User.
			
			switch (choice) {

			
			//Creation of a new Account
			
			case 1:
				System.out.println("----CREATE NEW ACCOUNT(Minimun balance is 1000)----");
				System.out.println("Enter name: ");
				custName = sc.next();
				
				
				while(true) {
					System.out.println("Enter Mobile No");
					mobile = sc.nextLong();
					if(String.valueOf(mobile).length() == 10) {
						break;
					}
					else {
						System.out.println("Enter a Valid Mobile Number Please Enter Again");
					}
				}
				System.out.println("Enter account type either a saving or checking: ");
				accType = sc.next();
				System.out.println("Enter branch: ");
				branch = sc.next();
				
				balance = 1000; //Minimum Balance in every account when created
				
				account = new Accounts(accNo, custName, mobile, accType, branch, balance);
				System.out.println(service.addAccount(account) + " with Account Number " + accNo);
				accNo++;
				break;

				
				//Withdraw from an Account
				
				
			case 2:
				System.out.println("----WITHDRAW FROM ACCOUNT----");
				System.out.println("Enter account number from which you wish to withdraw: ");
				long wdAccNo = sc.nextLong();
				try {
					System.out.println(service.getAccount(wdAccNo));
					System.out.println("Enter amount you wish to withdraw: ");
					double wdAmount = sc.nextDouble();
					if (wdAmount <= (service.getAccount(wdAccNo).getBalance())) {
						System.out.println("Old Balance : " + service.getAccount(wdAccNo).getBalance());
						service.withdrawFromBalance(wdAccNo, wdAmount);
						System.out.println("New Balance : " + service.getAccount(wdAccNo).getBalance());
					} else {
						throw new NotEnoughBalance("Not enough Balance");
					}
				} catch (AccountNotFound anf) {
					System.out.println("Invalid Account Number...");
				} catch (NotEnoughBalance neb) {
					System.out.println("Not enough Balance");
				}
				break;

				
				//Deposit into an Account
				
			case 3:
				System.out.println("----DEPOSIT INTO ACCOUNT----");
				System.out.println("Enter account number into which you wish to deposit: ");
				long dpAccNo = sc.nextLong();
				try {
					System.out.println(service.getAccount(dpAccNo));
					System.out.println("Enter amount you wish to deposit: ");
					double dpAmount = sc.nextDouble();
					System.out.println("Old Balance : " + service.getAccount(dpAccNo).getBalance());
					service.depositIntoBalance(dpAccNo, dpAmount);
					System.out.println("New Balance : " + service.getAccount(dpAccNo).getBalance());
				} catch (AccountNotFound anf) {
					System.out.println("Invalid Account Number...");
				}
				break;

				
				
				//Show Customer Details
				
			case 4:
				System.out.println("----SHOW DETAILS----");
				System.out.println("Enter account number to show details: ");
				long accNoQuery = sc.nextLong();
				try {
					System.out.println(service.getAccount(accNoQuery));
				} catch (AccountNotFound anf) {
					System.out.println("Enter valid account number....");
				}
				break;

				
				//Transfer of Funds.
				
			case 5:
				System.out.println("----FUND TRANSFER----");
				System.out.println("Enter your account number to start transaction: ");
				long transFromAcc = sc.nextLong();
				try {
					System.out.println(service.getAccount(transFromAcc));
					System.out.println("Enter which service you wish to use:\n1. NEFT\n2. RTGS\n3. IMPS");
					int transServiceRequested = sc.nextInt();
					switch (transServiceRequested) {
					
					//NEFT Transfer
					
					case 1:
						System.out.println("NEFT selected...");
						System.out.println("Enter beneficiary account number: ");
						long neftAccNo = sc.nextLong();
						try {
							service.getAccount(neftAccNo);
						} catch (AccountNotFound anf) {
							System.out.println("Wrong Account Number of beneficiary... Transaction Cancelled...");
						}
						System.out.println("Enter Amount to transfer: ");
						double neftAmount = sc.nextDouble();
						
						
						try {
							double transWithdrawAmount = neftAmount;
							if (transWithdrawAmount <= (service.getAccount(transFromAcc).getBalance())) {
								System.out.println("Old Balance of " + transFromAcc + " is " + service.getAccount(transFromAcc).getBalance());
								service.withdrawFromBalance(transFromAcc, transWithdrawAmount);
								System.out.println("New Balance of " + transFromAcc + " is " + service.getAccount(transFromAcc).getBalance());
							} else {
								throw new NotEnoughBalance("Not enough Balance");
							}
						} catch (NotEnoughBalance neb) {
							System.out.println("Not enough Balance");
							break;
						}
						
						try {
							double transDepositAmount = neftAmount;
							System.out.println("Old Balance of " + neftAccNo + " is " + service.getAccount(neftAccNo).getBalance());
							service.depositIntoBalance(neftAccNo, transDepositAmount);
							System.out.println("New Balance of " + neftAccNo + " is " + service.getAccount(neftAccNo).getBalance());
						} finally {
							System.out.println("Transaction Successful via NEFT.");
							accNoFrom = transFromAcc;
							accNoTo = neftAccNo;
							amount = neftAmount;
							dateOfTrans = new Date();
							transType = "NEFT";
							balance = service.getAccount(transFromAcc).getBalance();
							transaction = new Transactions(transId, accNoFrom, accNoTo, amount, dateOfTrans, transType, balance);
							transId++;
							transService.addTransactionNEFT(transFromAcc, neftAccNo, transaction);
							System.out.println(service.getAccount(transFromAcc));
						}
						
						break;
						
						//RTGS Transfer
						
					case 2:
						System.out.println("RTGS selected...");
						System.out.println("Enter beneficiary account number: ");
						long rtgsAccNo = sc.nextLong();
						try {
							service.getAccount(rtgsAccNo);
						} catch (AccountNotFound anf) {
							System.out.println("Wrong Account Number of beneficiary... Transaction Cancelled...");
						}
						System.out.println("Enter Amount to transfer: ");
						double rtgsAmount = sc.nextDouble();
						
						
						try {
							double transWithdrawAmount = rtgsAmount;
							if (transWithdrawAmount <= (service.getAccount(transFromAcc).getBalance())) {
								System.out.println("Old Balance of " + transFromAcc + " is " + service.getAccount(transFromAcc).getBalance());
								service.withdrawFromBalance(transFromAcc, transWithdrawAmount);
								System.out.println("New Balance of " + transFromAcc + " is " + service.getAccount(transFromAcc).getBalance());
							} else {
								throw new NotEnoughBalance("Not enough Balance");
							}
						} catch (NotEnoughBalance neb) {
							System.out.println("Not enough Balance");
							break;
						}
						
						try {
							double transDepositAmount = rtgsAmount;
							System.out.println("Old Balance of " + rtgsAccNo + " is " + service.getAccount(rtgsAccNo).getBalance());
							service.depositIntoBalance(rtgsAccNo, transDepositAmount);
							System.out.println("New Balance of " + rtgsAccNo + " is " + service.getAccount(rtgsAccNo).getBalance());
						} finally {
							System.out.println("Transaction Successful via RTGS.");
							accNoFrom = transFromAcc;
							accNoTo = rtgsAccNo;
							amount = rtgsAmount;
							dateOfTrans = new Date();
							transType = "RTGS";
							balance = service.getAccount(transFromAcc).getBalance();
							transaction = new Transactions(transId, accNoFrom, accNoTo, amount, dateOfTrans, transType, balance);
							transId++;
							transService.addTransactionNEFT(transFromAcc, rtgsAccNo, transaction);
							System.out.println(service.getAccount(transFromAcc));
						}
						break;
						
						//IMPS Transfer
						
					case 3:
						System.out.println("IMPS selected...");
						System.out.println("Enter beneficiary account number: ");
						long impsAccNo = sc.nextLong();
						try {
							service.getAccount(impsAccNo);
						} catch (AccountNotFound anf) {
							System.out.println("Wrong Account Number of beneficiary... Transaction Cancelled...");
						}
						System.out.println("Enter Amount to transfer: ");
						double impsAmount = sc.nextDouble();
						
						
						try {
							double transWithdrawAmount = impsAmount;
							if (transWithdrawAmount <= (service.getAccount(transFromAcc).getBalance())) {
								System.out.println("Old Balance of " + transFromAcc + " is " + service.getAccount(transFromAcc).getBalance());
								service.withdrawFromBalance(transFromAcc, transWithdrawAmount);
								System.out.println("New Balance of " + transFromAcc + " is " + service.getAccount(transFromAcc).getBalance());
							} else {
								throw new NotEnoughBalance("Not enough Balance");
							}
						} catch (NotEnoughBalance neb) {
							System.out.println("Not enough Balance");
							break;
						}
						
						try {
							double transDepositAmount = impsAmount;
							System.out.println("Old Balance of " + impsAccNo + " is " + service.getAccount(impsAccNo).getBalance());
							service.depositIntoBalance(impsAccNo, transDepositAmount);
							System.out.println("New Balance of " + impsAccNo + " is " + service.getAccount(impsAccNo).getBalance());
						} finally {
							System.out.println("Transaction Successful via RTGS.");
							accNoFrom = transFromAcc;
							accNoTo = impsAccNo;
							amount = impsAmount;
							dateOfTrans = new Date();
							transType = "IMPS";
							balance = service.getAccount(transFromAcc).getBalance();
							transaction = new Transactions(transId, accNoFrom, accNoTo, amount, dateOfTrans, transType, balance);
							transId++;
							transService.addTransactionNEFT(transFromAcc, impsAccNo, transaction);
							System.out.println(service.getAccount(transFromAcc));
						}
						break;
					default:
						System.out.println("Wrong Input... Transaction Cancelled...");
						break;
					}
				} catch (AccountNotFound anf) {
					System.out.println("Enter valid account number...");
				}
				break;
				
				//Displaying the Account Details.

			case 6:
				System.out.println("----SHOW ACCOUNT TRANSACTIONS----");
				System.out.println("Enter account number to show transactions: ");
				long showTransAccNo = sc.nextLong();
				try {
					service.getAccount(showTransAccNo);
					System.out.println(transService.getTransForAccNo(transaction, showTransAccNo)); 
				} catch (AccountNotFound anf) {
					System.out.println("Enter valid account number....");
				}
				break;
				
				
				//Exiting the Application

			case 7:
				System.out.println("Ok Baiiii!!!!!");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Input. Try again!");
			}
		}
	}
}
