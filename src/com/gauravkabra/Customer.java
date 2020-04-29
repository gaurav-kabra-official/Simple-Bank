package com.gauravkabra;
import java.util.Scanner;

public class Customer{
	private String name;
	private int age;
	private String accountNo;
	private float balance;
	
	Scanner sc = new Scanner(System.in);
	
	public boolean setDetails(Customer[] customer, int current_customer_id) {
		try {
			boolean wantExit = this.wantExit();
			if(wantExit)
				return true;
			System.out.println("Enter name");
			this.name = sc.nextLine();
			System.out.println("Enter age");
			this.age = Integer.parseInt(sc.nextLine());
			if(this.age < 10 || this.age > 130)
				return false;
			System.out.println("Enter new account number");
			this.accountNo = sc.nextLine();
			//check if a/c no is unique
			for(int i=0; i<current_customer_id; i++) {
				if(customer[i].accountNo.equals(this.accountNo))
					return false;
			}
			return true;
		}
		catch(Exception e) {
			System.out.println("Invalid entry");
			return false;
		}
	}
	
	public Customer[] getNewArray(Customer[] ref) {
		int old_len = ref.length;
		int new_len = old_len*2;
		Customer[] customer = new Customer[new_len];
		for(int i=0;i<old_len;i++)
			customer[i] = ref[i];
		return customer;
	}
	
	public String getAccNo() {
		return this.accountNo;
	}
	
	public void depositeMoney() {
		// if user mistakenly chose this oper and want to exit
		// simply choose amount as 0
		System.out.println("Enter amount deposited");
		try {
			float amt = Float.parseFloat(sc.nextLine());
			if(amt < 0)
				throw new CustomeExceptionMessage("Amount is negative");
			this.balance += amt;
		}
		catch(CustomeExceptionMessage ex) {
			System.out.println(ex.getExceptionMessage());
		}
		catch(Exception ex) {
			System.out.println("Something is wrong...try again");
		}
	}
	
	public void withdrawMoney() {
		// if user mistakenly chose this oper and want to exit
		// simply choose amount as 0
		float amt=0;
		System.out.println("Enter amount to withdraw");
		try {
			amt = Float.parseFloat(sc.nextLine());
		}
		catch(Exception ex) {
			System.out.println("Invalid amount");
		}
		try {
			if(amt > this.balance || amt < 0)
				throw new CustomeExceptionMessage("Either amount is more than current balance or is negative");
			this.balance -= amt;
		}
		catch(CustomeExceptionMessage ex) {
			System.out.println(ex.getExceptionMessage());
		}
		catch(Exception ex) {
			System.out.println("Something is wrong...try again");
		}
	}
	
	public float getBalance() {
		return this.balance;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean wantExit() {
		System.out.println("If you want to exit type Y or *");
		String ch = sc.nextLine();
		if(ch.equals("Y") || ch.equals("*"))
			return true;
		return false;	
	}
}

