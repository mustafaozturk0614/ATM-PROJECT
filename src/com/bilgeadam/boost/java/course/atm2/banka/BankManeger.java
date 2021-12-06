package com.bilgeadam.boost.java.course.atm2.banka;

import com.bilgeadam.boost.java.course.atm2.account.CustomerAccount;
import com.bilgeadam.boost.java.course.atm2.account.Eft;
import com.bilgeadam.boost.java.course.atm2.account.Havale;
import com.bilgeadam.boost.java.course.atm2.account.Menager;
import com.bilgeadam.boost.java.course.atm2.util.BAUtils;

public class BankManeger implements Menager {
	
	private CustomerAccount customerAccount;
	
	private OtherBank otherBank;
	private Eft eft;
	private Havale havale;
	
	public BankManeger() {
		this.customerAccount = new CustomerAccount();
		
	}
	
	@Override
	public double addMoney() {
		
		double ammount = BAUtils.readDouble("lütfen Yatırmak istediğiniz tutarı giriniz");
		this.getCustomerAccount().setAmmount(this.getCustomerAccount().getAmmount() + ammount);
		System.out.println("işelminiz Başarıyla tamamlanmıştır");
		System.out.printf("  %10.2fTL hesabınıza aktarılmıştır\n", ammount);
		return this.getCustomerAccount().getAmmount();
	}
	
	@Override
	public double reduceMoney() {
		double ammount = BAUtils.readDouble("Lütfen çekmek istediğiniz tutarı giriniz");
		if (this.customerAccount.getAmmount() > ammount) {
			String answer = BAUtils
					.readString("Hesabınızdan *" + ammount + "* tutar çekilecektir onaylıyorsanız 'e' tuşuna basınız");
			if (answer.equalsIgnoreCase("e")) {
				System.out.println("işelminiz Başarıyla tamamlanmıştır");
				System.out.printf(" %10.2fTL  hesabınızdan çekilmiştir\n", ammount);
				
				this.customerAccount.setAmmount(this.customerAccount.getAmmount() - ammount);
			} else {
				System.out.println("işleminiz iptal edilmiştir...");
			}
			
		} else {
			System.out.println("Hesabınızda Yeterli para yoktur");
		}
		return this.customerAccount.getAmmount();
	}
	
	@Override
	public double sendHAvale() {
		
		String accountNumber = BAUtils.readString("Lütfen işlem yapmak istediğiniz hesap numarasını giriniz");
		CustomerAccount account = this.customerAccount.getBank().getCustomer().get(accountNumber);
		if (account == null) {
			System.out.println("böyle bir müşteri bulunmadı");
			
		} else {
			double ammount = BAUtils.readDouble("Lütfen yatırmak istediğiniz tutarı giriniz");
			
			if (this.customerAccount.getAmmount() > ammount) {
				String check = BAUtils.readString("İşlemi onaylıyorsanız  Evet(E) tuşuna basınız ");
				if (check.equalsIgnoreCase("e")) {
					account.setAmmount(account.getAmmount() + ammount);
					this.customerAccount.setAmmount(this.customerAccount.getAmmount() - ammount);
					System.out.println("işelminiz Başarıyla tamamlanmıştır");
					System.out.printf("%s %s adlı kişiye %10.2fTL  TL havale yapılmıştır\n",
							account.getPerson().getName(), account.getPerson().getSurName(), ammount);
					this.havale = new Havale();
					
					this.havale.getAccounts()[0] = this.customerAccount;
					this.havale.getAccounts()[1] = account;
					this.havale.setBank(account.getBank());
					this.customerAccount.getBank().getHavaleList().put(this.havale.getId(), this.havale);
					this.customerAccount.getHavaleList().put(this.havale.getId(), this.havale);
					return this.customerAccount.getAmmount();
				} else {
					System.out.println("işleminiz iptal edilmiştir...");
				}
			} else {
				System.out.println("hesabınızda yeterli miktarda para yoktur");
			}
			
		}
		
		return this.customerAccount.getAmmount();
		
	}
	
	@Override
	public double sendEft() {
		this.otherBank = new OtherBank();
		
		int accountNumber = BAUtils.readInt("Lütfen işlem yapmak istediğiniz hesap numarasını giriniz");
		CustomerAccount account = this.otherBank.getEftAccounts().get(accountNumber);
		if (account == null) {
			System.out.println("böyle bir müşteri bulunmadı");
			
		} else {
			account.setBank(this.otherBank);
			double ammount = BAUtils.readDouble("Lütfen yatırmak istediğiniz tutarı giriniz");
			if (this.getCustomerAccount().getAmmount() > ammount) {
				String check = BAUtils.readString("İşlemi onaylıyorsanız  Evet(E) tuşuna basınız ");
				if (check.equalsIgnoreCase("e")) {
					account.setAmmount(account.getAmmount() + ammount);
					this.customerAccount.setAmmount(this.customerAccount.getAmmount() - ammount);
					
					System.out.println("işelminiz Başarıyla tamamlanmıştır");
					System.out.printf("%s %s adlı kişiye %10.2fTL  TL eft yapılmıştır\n", account.getPerson().getName(),
							account.getPerson().getSurName(), ammount);
					if (account.getAccountNumber().startsWith("100")) {
						account.getBank().setBankName("Diğer Bank");
						
					} else {
						account.getBank().setBankName("Başka Bank");
					}
					this.eft = new Eft();
					this.eft.getAccounts()[0] = this.customerAccount;
					this.eft.getAccounts()[1] = account;
					this.eft.getBanks()[0] = this.customerAccount.getBank();
					this.eft.getBanks()[1] = account.getBank();
					this.customerAccount.getBank().getEftList().put(this.eft.getId(), this.eft);
					this.customerAccount.getEftList().put(this.eft.getId(), this.eft);
					return this.customerAccount.getAmmount();
					
				} else {
					System.out.println("işleminiz iptal edilmiştir...");
				}
			} else {
				System.out.println("hesabınızda yeterli miktarda para yoktur");
			}
			
		}
		
		return this.customerAccount.getAmmount();
	}
	
	@Override
	public void showMoney() {
		System.out.printf("Sayın %s %s \n", this.customerAccount.getPerson().getName(),
				this.customerAccount.getPerson().getSurName());
		System.out.printf("%s nolu  hesabınızda %10.2fTL  TL Bakiyeniz vardır \n",
				this.customerAccount.getAccountNumber(), this.customerAccount.getAmmount());
		
	}
	
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}
	
	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}
	
	public OtherBank getOtherBank() {
		return otherBank;
	}
	
	public void setOtherBank(OtherBank otherBank) {
		this.otherBank = otherBank;
	}
	
	public Eft getEft() {
		return eft;
	}
	
	public void setEft(Eft eft) {
		this.eft = eft;
	}
	
	public Havale getHavale() {
		return havale;
	}
	
	public void setHavale(Havale havale) {
		this.havale = havale;
	}
	
}
