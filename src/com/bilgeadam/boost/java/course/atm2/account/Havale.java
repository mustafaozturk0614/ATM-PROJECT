package com.bilgeadam.boost.java.course.atm2.account;

import com.bilgeadam.boost.java.course.atm2.banka.Bank;

public class Havale {
	private static int count = 0;
	private int id = 0;
	private CustomerAccount[] accounts;
	private Bank bank;
	
	public Havale() {
		count++;
		this.id = count;
		this.accounts = new CustomerAccount[2];
	}
	
	public CustomerAccount[] getAccounts() {
		return accounts;
	}
	
	public void setAccounts(CustomerAccount[] accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return "----------\nHavale Information [ havale_id= " + this.id + "\n banka= " + this.getBank()
				+ "\ngönderen hesap= " + this.accounts[0] + "\nalıcı hesap= " + this.accounts[1] + "]\n----------";
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
