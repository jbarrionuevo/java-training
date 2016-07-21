package edu.globant.day3.tema.exercises.bankingApp;

import java.util.List;
import java.util.Scanner;

public class Bank {
	List<BankTeller> bankTellers;

	public void addBankTeller(BankTeller bt) {
		bankTellers.add(bt);
	}

	public void removeBankTeller(BankTeller bt) {
		bankTellers.remove(bt);
	}

	private Scanner scanner;

	public Bank() {
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		System.out.println("******************************************************");
		System.out.println("**********Bank App by JBARRIONUEVO**********");
		System.out.println("******************************************************");

		Bank bank = new Bank();

		while (true) {
			try {
				bank = bank.mainMenu(bank);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private Bank mainMenu(Bank bank) {
		System.out.println("");
		System.out.println("***Bank Main menu***");
		String consoleInput;

		do {
			System.out.println("		1-Menu 1");
			System.out.println("		2-Menu 2");
			System.out.println("		3-Menu 3");
			System.out.println("		4-Menu 4");
			System.out.println("		5-Menu 5");
			System.out.println("		6-bye!");

			consoleInput = scanner.next();

			switch (consoleInput) {
			case "1":
				return bank.submenu1(bank);
			case "2":
				return bank.submenu2(bank);
			case "3":
				return bank.submenu3(bank);
			case "4":
				return bank.submenu4(bank);
			case "5":
				return bank.submenu5(bank);
			case "6":

				return bank;

			default:
				System.out.println("***Invalid selection***");
			}
		} while (consoleInput != "bye");
		return bank;
	}

	private Bank submenu1(Bank bank) {
		Bank ret = null;
		System.out.println("***Submenu 1***");
		@SuppressWarnings("unused")
		String consoleInput;
		ret = bank.mainMenu(bank);
		return ret;
	}

	private Bank submenu2(Bank bank) {
		Bank ret = null;
		System.out.println("***Submenu 2***");
		@SuppressWarnings("unused")
		String consoleInput;
		ret = bank.mainMenu(bank);
		return ret;
	}

	private Bank submenu3(Bank bank) {
		Bank ret = null;
		System.out.println("***Submenu 3***");
		@SuppressWarnings("unused")
		String consoleInput;
		ret = bank.mainMenu(bank);
		return ret;
	}

	private Bank submenu4(Bank bank) {
		Bank ret = null;
		System.out.println("***Submenu 4***");
		@SuppressWarnings("unused")
		String consoleInput;
		ret = bank.mainMenu(bank);
		return ret;
	}

	private Bank submenu5(Bank bank) {
		Bank ret = null;
		System.out.println("***Submenu 5***");
		@SuppressWarnings("unused")
		String consoleInput;
		ret = bank.mainMenu(bank);
		return ret;
	}
}