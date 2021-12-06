package com.bilgeadam.boost.java.course.atm2.banka;

import java.util.HashMap;
import java.util.Scanner;

import com.bilgeadam.boost.java.course.atm2.account.CustomerAccount;
import com.bilgeadam.boost.java.course.atm2.account.Eft;
import com.bilgeadam.boost.java.course.atm2.account.Havale;

public abstract class Bank {
	static Scanner scanner = new Scanner(System.in);
	
	private String bankName;
	private int id;
	private HashMap<Integer, Havale> havaleList;
	private HashMap<Integer, Eft> eftList;
	private HashMap<String, CustomerAccount> customer;
	
	public Bank() {
		this.id = 0;
		this.havaleList = new HashMap<>();
		this.eftList = new HashMap<>();
		this.customer = new HashMap<>();
		
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public HashMap<String, CustomerAccount> getCustomer() {
		return customer;
	}
	
	public void setCustomer(HashMap<String, CustomerAccount> customer) {
		this.customer = customer;
	}
	
}
