package com.bilgeadam.boost.java.course.atm2.account;

import java.util.HashMap;
import java.util.Scanner;

import com.bilgeadam.boost.java.course.atm2.banka.Bank;
import com.bilgeadam.boost.java.course.atm2.banka.MyBank;
import com.bilgeadam.boost.java.course.atm2.util.BAUtils;

public class CustomerAccount extends Account implements IAccount {
	static Scanner scanner = new Scanner(System.in);
	private HashMap<Integer, Havale> havaleList;
	private HashMap<Integer, Eft> eftList;
	
	public CustomerAccount() {
		super();
		bank = new MyBank();
		this.havaleList = new HashMap<>();
		this.eftList = new HashMap<>();
		
	}
	
	public CustomerAccount(double ammount, Person person) {
		super(ammount, person);
		
	}
	
	@Override
	public CustomerAccount register(Account customer) {
		count++;
		this.id = this.setId(count);
		this.accountNumber = bank.getId() + "" + id;
		customer.getPerson().setName(BAUtils.readString("lütfen isminizi giriniz"));
		
		customer.getPerson().setSurName(BAUtils.readString("lütfen soyisminizi giriniz"));
		
		customer.setPasword(BAUtils.readString("lütfen şifrenizi giriniz"));
		
		System.out.println("Bankamıza Hoşgeldiniz: " + "Sayın " + customer.getPerson().getName().toUpperCase() + " "
				+ customer.getPerson().getSurName().toUpperCase());
		System.out.printf("Hesap numranız %s : \n ", customer.getAccountNumber());
		return (CustomerAccount) customer;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public HashMap<Integer, Havale> getHavaleList() {
		return havaleList;
	}
	
	public void setHavaleList(HashMap<Integer, Havale> havaleList) {
		this.havaleList = havaleList;
	}
	
	public HashMap<Integer, Eft> getEftList() {
		return eftList;
	}
	
	public void setEftList(HashMap<Integer, Eft> eftList) {
		this.eftList = eftList;
	}
	
}
