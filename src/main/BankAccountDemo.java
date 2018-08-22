package main;

import java.util.Scanner;

import lib.BankAccount;

public class BankAccountDemo {
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		BankAccount b = new BankAccount("jdl0000");

		String fall = "\n";
		String command = "";

		do {
			if (command.isEmpty()) {
				System.out.println("Select an action for your account: " + fall + fall
						+ "To view your current balance, type balance," + fall + "To deposit cash, type deposit," + fall
						+ "To withdraw cash, type withdraw," + fall + "To view account details, type view," + fall
						+ "To exit, type exit.");

				command = user.nextLine();
				command.toLowerCase();
			} else {
				switch (command) {
				case "balance":
					System.out.println("Your current balance is £" + b.getBalance());
					System.out.println(fall);
					break;

				case "view":
					System.out.println(b.toString());
					System.out.println(fall);
					break;

				case "deposit":
					/*
					 * Print a statement asking the user to enter a deposit amount. Confirm the
					 * amount with the user. Update the account balance.
					 */
					int repeat = 0;
					while (repeat < 1) {
						System.out.println("how much would you like to deposit?");
						int amount = user.nextInt();

						System.out.println(fall + "Are you sure you would like to deposit £" + amount + "?" + fall
								+ "yes:1, no:0");
						int confirm = user.nextInt();
						
						if (confirm > 0) {
							System.out.println(fall + "Current balance is £" + b.getBalance());
							b.deposit(amount);
							System.out.println("your new balance is £" + b.getBalance() + fall);
							repeat++;
						}
					}
					break;

				default:
					break;
				}
				command = "";
			}

		} while (!command.equals("exit"));
		user.close();
		System.out.println("Interface closed!");
	}
}
