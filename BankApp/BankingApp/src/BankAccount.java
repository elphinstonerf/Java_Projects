import java.util.Scanner;

public class BankAccount {

	String name;
	int num;
	double balance;
			
			
	public BankAccount(String newName, int newNum){
		this.name = newName;
		this.num = newNum;
	}
			
	public double checkBalance() {
		return balance;
	}
	public void deposit(double money) {
		balance = money + balance;
	}
	public void withdraw(double money) {
		double tempBalance = balance - money;
		if (tempBalance < 0) {
				System.out.println("Insufficient Funds"); // Validation for sufficient funds.
		}
		else {
			balance = tempBalance;
		}
	}
	public void menu() {
		int option;
		Scanner input = new Scanner(System.in);
		System.out.println("Hello "+name);
	    System.out.println("Your ID:"+num + "\n");
	    System.out.println("1) Check Your Balance");
	    System.out.println("2) Deposit an Amount");
	    System.out.println("3) Withdraw an Amount");
	    System.out.println("4) Exit Application");
		        
	    do{
		    System.out.println("********************************************");
		    System.out.println("Choose an option");
	        option = input.nextInt();
	        System.out.println("\n");
		            
	        if (option == 1) {
	        	System.out.println("********************************************");
	        	System.out.println("Your Balance is $" + balance);
	        }
	        else if (option == 2) {
	        	System.out.println("********************************************");
	            System.out.println("Enter an amount to deposit");
	            double tempMoney = input.nextDouble();
	            deposit(tempMoney);
	            System.out.printf("You have deposited $%.2f \n", tempMoney);
	        }
	        else if (option == 3) {
	        	System.out.println("********************************************");
	            System.out.println("Enter an amount to withdraw");
	            double withdraw = input.nextDouble();
	            if(balance - withdraw < 0) {
	            	System.out.println("You have insufficient funds.");
	            }
	            else {
	            	balance = balance - withdraw;
	            	System.out.printf("You have withdran $%.2f \n", withdraw);
	            }
	        }
	        else {
	            System.out.println("That is not an option. Please try again.");
	            System.out.println("1) Check Your Balance");
	    	    System.out.println("2) Deposit an Amount");
	    	    System.out.println("3) Withdraw an Amount");
	    	    System.out.println("4) Exit Application");
	        }
	    } while (option != 4);
	    System.out.println("********************************************");
	    System.out.println("********************************************");
	    System.out.println("Thank you for Banking with us!");
	}	
}


