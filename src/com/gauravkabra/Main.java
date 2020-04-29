package com.gauravkabra;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		// operation code
		int oper = -1;
		// operations
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();
		while(true) {
			System.out.println("Enter number corresponding to desired operation.\n"
					+ "1 : Add customer\n"
					+ "2 : Deposite money\n"
					+ "3 : Check balance\n"
					+ "4 : Withdraw money\n"
					+ "5 : Create summary for bank\n"
					+ "6 : Exit");
			try {
				oper = Integer.parseInt(sc.nextLine());
			}
			catch(Exception ex) {
				System.out.println("Invalid operation.");
				continue;
			}
			switch(oper) {
			case 1:
				bank.addCustomer();
				break;
			case 2:
				bank.depositeMoney();
				break;
			case 3:
				bank.checkBalance();
				break;
			case 4:
				bank.withdrawMoney();
				break;
			case 5:
				bank.createSummary();
				break;
			case 6:
				System.exit(0);
			default:
				bank.raiseException();
			}
		}
	}

}
