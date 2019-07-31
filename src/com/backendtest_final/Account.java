package com.backendtest_final;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.Calendar;

public class Account {

	 Map<String, Float> accounts;
	 Map<String, String> statements;
	 public Account()
	 {
		 accounts = new HashMap<>();
		 statements = new HashMap<>();
		 
	 } 	
	 private void setAccountMovement(String Account, String action)
	 {
		 Date currentDate = Calendar.getInstance().getTime();
		 
		 if (this.statements.containsKey(Account))
		 {
			 this.statements.put(Account, this.statements.get(Account)+ "\n" + currentDate + " " + action);
		 }
		 else
		 {
			 this.statements.put(Account, currentDate + " " + action);
		 }
		 
	 }
	 public void CreateAccount(String account, float balance)
	 {
		 System.out.println("Account to be created=>"+ account);
		 this.accounts.put(account, balance);
		 setAccountMovement(account, "Account created with balance "+ balance);
	 }
	
	 public String getAccountMovement(String Account)
	 {
		 if (this.statements.containsKey(Account))
		 {
			 return this.statements.get(Account).toString();
		 }
		 else
		 {
			 return "Account does not exist";
		 }
	 }
	 public Boolean getAccount(String account)
	 {
		if (this.accounts.containsKey(account))
			return true;
		
		return false;
	 }
	 public void setBalanceAccount(String account, float balance)
	 {
		 System.out.println("Account: "+account+" Balance = " + balance);
		 this.accounts.put(account, balance);
		 if (balance > 0)
			 this.setAccountMovement(account, "Account Balance (+)" + balance );
		 else if (balance < 0)
		 {
			 this.setAccountMovement(account, "Account Balance (-)" + balance );
		 }
	 }
	 public Float getBalanceAccount(String account)
	 {
		 return this.accounts.get(account);
	 }
	 public String transferFunds(String sourceAccount, String destinationAccount, float Amount)
	 {
		 if (!this.getAccount(sourceAccount))
		 {
			 return "Source Account does not exist!";
		 }
		 else
		 {
			 if (!this.getAccount(destinationAccount))
			 {
				 return "Destination Account does not exist!";
			 }
			 if (this.getBalanceAccount(sourceAccount) < Amount)
			 {
				 return "Source Account with insufficient funds!";
			 } 
			 this.setBalanceAccount(destinationAccount, this.getBalanceAccount(destinationAccount) + Amount);
			 setAccountMovement(destinationAccount, "Funds received from Account "+ sourceAccount + " in amount of " + Amount );
			 this.setBalanceAccount(sourceAccount, this.getBalanceAccount(sourceAccount) - Amount);
			 this.setAccountMovement(sourceAccount, "Funds transferred to Account "+ destinationAccount + " in amount of " + Amount );
		 }
		 return "Amount "+Amount+" successfully transferred!";

	 }
	/*
	 * public static void main(String[] args) { Account a = new Account();
	 * a.CreateAccount("10000120", 1000); a.CreateAccount("10000121", 0);
	 * System.out.println("Balance Account = "+ a.getBalanceAccount("10000120"));
	 * System.out.println("Transferring funds "+ a.transferFunds("10000120",
	 * "10000121", 10)); System.out.println("Account 10000120 funds = " +
	 * a.getBalanceAccount("10000120"));
	 * System.out.println("Account 10000121 funds = " +
	 * a.getBalanceAccount("10000121")); System.out.println("Transferring funds "+
	 * a.transferFunds("10000120", "10000121", 25));
	 * System.out.println("Account 10000120 funds = " +
	 * a.getBalanceAccount("10000120"));
	 * System.out.println("Account 10000121 funds = " +
	 * a.getBalanceAccount("10000121"));
	 * 
	 * System.out.println("Account Statement 10000120");
	 * System.out.println(a.getAccountMovement("10000120"));
	 * System.out.println("Account Statement 10000121");
	 * System.out.println(a.getAccountMovement("10000121"));
	 * 
	 * }
	 */
}