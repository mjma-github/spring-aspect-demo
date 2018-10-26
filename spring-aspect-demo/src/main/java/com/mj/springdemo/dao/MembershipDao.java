package com.mj.springdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

	public boolean addSillyMember() {
		
		System.out.println(">>>"+getClass() + ".addSillyMember()");
		
		return true;
	}
	
	//public boolean addAccount() {
	public void addAccount() {
		
		System.out.println(">>>"+getClass() + ".addAccount(): DOING MY DB WORK: ADDING AN ACCOUNT");
		//return true;
	}	
}
