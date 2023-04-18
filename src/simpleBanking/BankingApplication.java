package simpleBanking;

import java.util.Scanner;

public class BankingApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccount ba = registerNewUserWithPrompts(sc);
		String returnedOption = "1";
		while(!returnedOption.equals("4")) {
			showMenu();
			returnedOption = sc.next();
			switch (returnedOption) {
			case "1":
				System.out.println("Account Balance: " + ba.getAccountBalance());
				break;
			case "2":
				performDepositWithPrompts(sc, ba);
				break;
			case "3":
				performWithdrawlWithPrompts(sc, ba);
			case "4":
				System.out.println("Thank you for banking with us!\n");
				break;
			default:
				System.out.println("'" + returnedOption + "' is not a valid input.  Try again\n");
				break;
			}
		}
//		sc.close();
	}
	
	// ***** Static Methods ************************************************
	static BankAccount registerNewUserWithPrompts(Scanner sc) {
		System.out.print("Hello, thank you for creating an account with us!\n" + 
				"Please input the account holders name: ");
		String response = sc.next();
		while(response.contentEquals("") || response == null) {
			System.out.print("Whoops! " + response + " is not a valid name.\n" + 
				       "Please input the account holders name: ");
			response = sc.next();
		}
		return new BankAccount(response);
	}
	
	static void performDepositWithPrompts(Scanner sc, BankAccount ba) {
		String response = "";
		while(true){
			System.out.print("How much would you like to deposit?\n\t$");
			response = sc.next();
			try {
				double toDeposit = Double.parseDouble(response);
				if(ba.deposit(toDeposit)) {
					System.out.print("You have added $" + toDeposit + " to your bank account!\n");
					return;
				}
			}catch(Exception e) {
				System.out.print("\nWhoops, that is not a valid ammount!  \n" + 
						"Don't include any non numeric digits or negative numbers in your response.\n");
			}
		}
	}
	
	static void performWithdrawlWithPrompts(Scanner sc, BankAccount ba) {
		String response = "";
		while(true){
			System.out.print("How much would you like to withdrawl?\n\t$");
			response = sc.next();
			try {
				double toWithdrawl = Double.parseDouble(response);
				if(ba.withdrawl(toWithdrawl)) {
					System.out.print("You have removed $" + toWithdrawl + " to your bank account!\n");
					return;
				}
				System.out.print("\nWhoops, you only have $" + ba.getAccountBalance() + " available to withdrawl.  Try again.\n");
			}catch(Exception e) {
				System.out.print("\nWhoops, that is not a valid ammount!  \n" + 
						"Don't include any non numeric digits or negative numbers in your response.\n");
			}
		}
	}
	static void showMenu() {
		String displayString = 
				"Please select an option from the list\n" +
				"1. View Account Balance\n" + 
			    "2. Deposit\n" + 
			    "3. Withdrawl\n" + 
			    "4. Exit\n";
		System.out.println(displayString);
	}
	
}
