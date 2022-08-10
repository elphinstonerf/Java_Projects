import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello and welcome to your Banking App");
		System.out.println("Please enter your name and account number.");
		String customerName = input.nextLine();
		while (!input.hasNextInt()) { 												// Validation
		    System.out.println("Enter a valid number");
		   	input.nextLine();
		    }
		int customerNumber = input.nextInt();
		BankAccount account = new BankAccount(customerName, customerNumber);
		account.menu();
	}

}

	
