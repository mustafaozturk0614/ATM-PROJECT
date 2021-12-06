package com.bilgeadam.boost.java.course.atm2.account;

public class Person {
	
	protected String name;
	protected String surName;
	protected String nationalİdenty;
	
	public Person() {
		
	}
	
	public Person(String name, String surName) {
		this.name = name;
		this.surName = surName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", surName=" + surName + ", nationalİdenty=" + nationalİdenty + "]";
	}
	
}
