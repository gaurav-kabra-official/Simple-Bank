package com.gauravkabra;
import java.util.Scanner;
public class Bank {
	// 1 customer assuming at min initially
	private int strength = 1;
	private int current_customer_id = 0;
	private Customer[] customer = new Customer[strength];
	
	Scanner sc = new Scanner(System.in);
	
	public void addCustomer() {
		Customer c = new Customer();
		//loop until customer details are not correctly set 
		while(!c.setDetails(customer, current_customer_id));
		// array reaches max capacity
		if(customer.length == strength) {
			customer = c.getNewArray(customer);
			strength = customer.length;
		}
		customer[current_customer_id++] = c;
	}
	
	public void depositeMoney() {
		System.out.println("Enter account number");
		String acno = sc.nextLine();
		for(int i=0;i<current_customer_id;i++) {
			if(customer[i].getAccNo().equals(acno)) {
				customer[i].depositeMoney();
				System.out.println("A/c "+customer[i].getAccNo()+"\nBal "+customer[i].getBalance());
				return;
			}
		}
		System.out.println("No such a/c number");
	}
	
	public void checkBalance() {
		System.out.println("Enter account number");
		String acno = sc.nextLine();
		for(int i=0;i<current_customer_id;i++) {
			if(customer[i].getAccNo().equals(acno)) {
				System.out.println("A/c "+customer[i].getAccNo()+"\nBal "+customer[i].getBalance());
				return;
			}
		}
		System.out.println("No such a/c number");
	}
	
	public void withdrawMoney() {
		System.out.println("Enter account number");
		String acno = sc.nextLine();
		for(int i=0;i<current_customer_id;i++) {
			if(customer[i].getAccNo().equals(acno)) {
				customer[i].withdrawMoney();
				System.out.println("A/c "+customer[i].getAccNo()+"\nBal "+customer[i].getBalance());
				return;
			}
		}
		System.out.println("No such a/c number");
	}
	
	public void createSummary() {
		// if no customer
		if(current_customer_id == 0)
			return;
		float maximum_amt=-1, minimum_amt=Float.MAX_VALUE;
		float total_amt=0;
		String richest="", poorest="";
		float bal;
		for(int i=0;i<current_customer_id;i++) {
			bal = customer[i].getBalance();
			total_amt += bal;
			maximum_amt = (maximum_amt < bal ? bal : maximum_amt);
			minimum_amt = (minimum_amt > bal ? bal : minimum_amt);
		}
		
		for(int i=0;i<current_customer_id;i++) {	
			bal = customer[i].getBalance();
			if(bal == maximum_amt)
				richest += customer[i].getName()+"-";
			if(bal == minimum_amt)
				poorest += customer[i].getName()+"-";
		}
		System.out.println("=== Summary ===");
		System.out.println("Maximum current amount : "+maximum_amt);
		System.out.println("Minimum current amount : "+minimum_amt);
		System.out.println("Maximum amount holder(s) : "+richest);
		System.out.println("Minimum amount holder(s) : "+poorest);
		System.out.println("TOTAL current balance : "+total_amt);
		
	}
	
	public void raiseException() {
		System.out.println("Invalid operation code");
	}
}
