package com.bilgeadam.boost.java.course.atm2.banka;

import java.util.HashMap;

import com.bilgeadam.boost.java.course.atm2.account.CustomerAccount;
import com.bilgeadam.boost.java.course.atm2.account.Person;

public class OtherBank extends Bank {
	private HashMap<Integer, CustomerAccount> eftAccounts;
	private HashMap<Integer, CustomerAccount> havaleAccounts;
	
	public OtherBank() {
		super();
		createBotAccount();
		
	}
	
	public void createBotAccount() {
		this.eftAccounts = new HashMap<>();
		this.havaleAccounts = new HashMap<>();
		CustomerAccount customerAccounts = new CustomerAccount(5000, new Person(" Bot1", "Bot1"));
		customerAccounts.setAccountNumber("10001");
		
		CustomerAccount customerAccounts1 = new CustomerAccount(1000, new Person(" Bot2", "Bot2"));
		customerAccounts1.setAccountNumber("10001");
		
		CustomerAccount customerAccounts2 = new CustomerAccount(15000, new Person(" Bot3", "Bot3"));
		customerAccounts2.setAccountNumber("20003");
		
		CustomerAccount customerAccounts3 = new CustomerAccount(500, new Person(" Bot4", "Bot4"));
		customerAccounts3.setAccountNumber("20004");
		
		this.eftAccounts.put(1001, customerAccounts1);
		this.eftAccounts.put(1002, customerAccounts2);
		this.eftAccounts.put(2003, customerAccounts3);
		this.eftAccounts.put(2004, customerAccounts);
		this.havaleAccounts.put(1001, customerAccounts1);
		this.havaleAccounts.put(1002, customerAccounts2);
		this.havaleAccounts.put(2003, customerAccounts3);
		this.havaleAccounts.put(2004, customerAccounts);
		
	}
	
	public HashMap<Integer, CustomerAccount> getEftAccounts() {
		return eftAccounts;
	}
	
	public void setEftAccounts(HashMap<Integer, CustomerAccount> eftAccounts) {
		this.eftAccounts = eftAccounts;
	}
	
	public HashMap<Integer, CustomerAccount> getHavaleAccounts() {
		return havaleAccounts;
	}
	
	public void setHavaleAccounts(HashMap<Integer, CustomerAccount> havaleAccounts) {
		this.havaleAccounts = havaleAccounts;
	}
	
}
