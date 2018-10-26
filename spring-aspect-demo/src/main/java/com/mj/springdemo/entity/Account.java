package com.mj.springdemo.entity;

public class Account {
	private String accountName;
	private String accountNumber;
	
	public Account(String accountName, String accountNumber) {
		super();
		this.accountName = accountName;
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", accountNumber=" + accountNumber + "]";
	}
}
