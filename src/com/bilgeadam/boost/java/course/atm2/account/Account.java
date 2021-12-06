package com.bilgeadam.boost.java.course.atm2.account;

import com.bilgeadam.boost.java.course.atm2.banka.Bank;

public abstract class Account {
	
	protected static int count = 4;
	protected int id = 0;
	
	protected String accountNumber;
	protected double ammount;
	protected String pasword;
	protected Person person;
	protected Bank bank;
	
	public Account() {
		person = new Person();
		
		this.ammount = 0;
		
	}
	
	public Account(double ammount, Person person) {
		this();
		this.ammount = 0;
		this.ammount = ammount;
		this.person = person;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int setId(int count) {
		return this.id = count;
		
	}
	
	public double getAmmount() {
		return ammount;
	}
	
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	
	public String getPasword() {
		return pasword;
	}
	
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	
	public Person getPerson() {
		
		return this.person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void setCount(int count) {
		Account.count = count;
	}
	
	@Override
	public String toString() {
		return "Account Information [accountNumber=" + accountNumber + ", ammount=" + ammount + ", person name:"
				+ person.getName() + " ,person surname: " + person.getSurName() + ", bank=" + bank.getBankName() + "]";
	}
	
}
