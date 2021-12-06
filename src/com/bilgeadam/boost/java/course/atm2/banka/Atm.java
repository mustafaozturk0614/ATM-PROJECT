package com.bilgeadam.boost.java.course.atm2.banka;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.bilgeadam.boost.java.course.atm2.util.BAUtils;

public class Atm {
	
	static private MyBank myBank = new MyBank();
	
	public void menu() {
		
		myBank.setBankName("EMPERYAL BANK");
		HashMap<Integer, String> menuItems = new LinkedHashMap<Integer, String>();
		do {
			BankManeger bankManeger = new BankManeger();
			bankManeger.getCustomerAccount().setBank(myBank);
			System.out.println("=================================");
			System.out.println("\t" + myBank.getBankName());
			System.out.println("=================================");
			
			menuItems.put(1, "Müşteri kaydı");
			menuItems.put(2, "Müşteri girişi");
			menuItems.put(3, "Müşteri listesi");
			menuItems.put(99, "çıkış");
			
			int input = BAUtils.menu(menuItems);
			
			switch (input) {
				case 1:
					
					bankManeger.setCustomerAccount(
							bankManeger.getCustomerAccount().register(bankManeger.getCustomerAccount()));
					
					bankManeger.getCustomerAccount().getBank().getCustomer()
							.put(bankManeger.getCustomerAccount().getAccountNumber(), bankManeger.getCustomerAccount());
					
					break;
				case 2:
					login(bankManeger, myBank);
					
					break;
				case 3:
					
					bankManeger.getCustomerAccount().getBank().getCustomer().entrySet().forEach(System.out::println);
					break;
				
				case 99:
					System.out.println("Sistemden çıkılıyor .......");
					System.out.println("Güle Güle.......");
					System.exit(0);
					break;
				
				default:
					break;
			}
		} while (BAUtils.wantToEnd("\nÇıkmak için 'q' ya basınız DEvam etmek için herhangi bir tuşa basınız", "q"));
		
	}
	
	private void proses(BankManeger bankManeger) {
		
		HashMap<Integer, String> menuItems = new LinkedHashMap<Integer, String>();
		while (true) {
			System.out.println("=================================");
			System.out.println("\t" + myBank.getBankName());
			System.out.println("=================================");
			System.out.printf("\n\t%s %s Hoşgeldiniz\n", bankManeger.getCustomerAccount().getPerson().getName(),
					bankManeger.getCustomerAccount().getPerson().getSurName());
			
			System.out.printf("\tBakiyeniz : %10.2fTL \n", bankManeger.getCustomerAccount().getAmmount());
			menuItems.put(1, "Para Yatırma");
			menuItems.put(2, "Para Çekme");
			menuItems.put(3, "Havale İşlemleri");
			menuItems.put(4, "Eft İşlemleri");
			menuItems.put(5, "Hesap Bilgileri");
			menuItems.put(6, "Eft Dökümanı");
			menuItems.put(7, "Havale Dökümanı");
			menuItems.put(8, "Ana Menü");
			menuItems.put(99, "çıkış");
			int input = BAUtils.menu(menuItems);
			
			switch (input) {
				case 1:
					bankManeger.addMoney();
					break;
				case 2:
					bankManeger.reduceMoney();
					break;
				case 3:
					bankManeger.sendHAvale();
					break;
				case 4:
					bankManeger.sendEft();
					break;
				case 5:
					bankManeger.showMoney();
					break;
				case 6:
					System.out.println("\t\t--Eft  Listesi--\n");
					bankManeger.getCustomerAccount().getEftList().entrySet().forEach(System.out::println);
					break;
				case 7:
					System.out.println("\t\t--Havale  Listesi--\n");
					bankManeger.getCustomerAccount().getHavaleList().entrySet().forEach(System.out::println);
					break;
				case 8:
					this.menu();
				case 99:
					System.out.println("Sistemden çıkılıyor .......");
					System.out.println("Güle Güle.......");
					System.exit(0);
					break;
				
				default:
					break;
			}
			
		}
		
	}
	
	private void login(BankManeger bankManeger, Bank bank) {
		int hak = 5;
		while (true) {
			
			String accountNumber = BAUtils.readString("lütfen Hesap numaranızı numaranızı giriniz");
			accountNumber.trim();
			System.out.println();
			String password = BAUtils.readString("lütfen şifrenizi numaranızı giriniz").trim();
			bankManeger.setCustomerAccount(bank.getCustomer().get(accountNumber));
			if (bankManeger.getCustomerAccount() != null) {
				
				if (bankManeger.getCustomerAccount().getPasword().equals(password)) {
					
					System.out.println("giriş işlemleriniz başarılı olmuştur");
					System.out.println();
					System.out.println("Devam Etmek için bir tuşa basın");
					proses(bankManeger);
				} else {
					hak--;
					System.out.println("yanlış şifre girdiniz");
					System.out.println("kalan hakkınız: " + (hak));
					System.out.println("------------------------------------");
					
				}
			} else {
				
				hak--;
				
				System.out.println("Hesap  numaranızı veya şifre yanlış girdiniz");
				System.out.println("kalan hakkınız: " + (hak));
				System.out.println("------------------------------------");
				
				String answerString = BAUtils.readString("Tekrar denemek istemiyorsanız çıkmak için q tuşuna basınız");
				if (answerString.equalsIgnoreCase("q")) {
					break;
					
				}
				if (hak == 0) {
					System.out.println(
							"5kere yanlış hakkınız kartınız bloke oldu müşteri hizmetlerini arayınız 444 555 99622");
					System.exit(0);
					
				}
				
			}
		}
		
	}
	
}
