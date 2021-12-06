package com.bilgeadam.boost.java.course.atm2.account;

import com.bilgeadam.boost.java.course.atm2.banka.Bank;

public class Eft {
	
	private static int count = 0;
	private CustomerAccount[] accounts;
	private Bank[] banks;
	private int id;
	
	public Eft() {
		count++;
		this.id = count;
		this.accounts = new CustomerAccount[2];
		this.banks = new Bank[2];
		
	}
	
	public CustomerAccount[] getAccounts() {
		return accounts;
	}
	
	public void setAccounts(CustomerAccount[] accounts) {
		this.accounts = accounts;
	}
	
	public Bank[] getBanks() {
		return banks;
	}
	
	public void setBanks(Bank[] banks) {
		this.banks = banks;
	}
	
	@Override
	public String toString() {
		return "----------\nEftInformation [" + "\neft_id = " + this.id + "\ngöndereh hesap  =" + this.accounts[0]
				+ "\ngönderen banka=" + this.banks[0] + "\nAlıcı Hesap= " + this.accounts[1] + "\nalıcı banka="
				+ this.banks[1].toString() + "]\n----------";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}