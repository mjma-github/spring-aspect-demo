package com.mj.springdemo.dao;

import org.springframework.stereotype.Component;

import com.mj.springdemo.entity.Account;

@Component
public class AccountDao {

	public void addAccount() {
		System.out.println(">>>"+getClass() + ".addAccount()");
	}
	
	public void addAccount(Account account) {
		System.out.println(">>>"+getClass() + ".addAccount(Account)");
	}
	
	public void addAccount(Account account, boolean isVip) {
		System.out.println(">>>"+getClass() + ".addAccount(Account, boolean)");
	}
}