package com.bilgeadam.boost.java.course.atm2.banka;

public class MyBank extends Bank {
	
	public MyBank() {
		super();
		setId(500);
	}
	
	@Override
	public String toString() {
		return "MyBank [getBankName()=" + getBankName() + "]";
	}
	
}
