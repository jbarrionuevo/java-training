package edu.globant.day3.tema.exercises.consoleApp.view;

import java.util.Scanner;

public class PhoneContacts {
	private Scanner scanner;

	public PhoneContacts() {
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		System.out.println("******************************************************");
		System.out.println("**********Phone Contacts App by JBARRIONUEVO**********");
		System.out.println("******************************************************");

		PhoneContacts menu = new PhoneContacts();

		while (true) {
			try {
				menu = menu.mainMenu(menu);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private PhoneContacts mainMenu(PhoneContacts menu) {
		System.out.println("");
		System.out.println("***Phone Contacts Main menu***");
		String consoleInput;

		do {
			System.out.println("		1-list existing contacts");
			System.out.println("		2-create a new contact");
			System.out.println("		3-add an existing contact");
			System.out.println("		4-modify an existing contact");
			System.out.println("		5-delete an existing contact");
			System.out.println("		6-bye!");

			consoleInput = scanner.next();

			switch (consoleInput) {
			case "1":
				return menu.submenuList(menu);
			case "2":
				return menu.submenuNew(menu);
			case "3":
				return menu.submenuAdd(menu);
			case "4":
				return menu.submenuModify(menu);
			case "5":
				return menu.submenuDelete(menu);
			case "6":

				return menu;

			default:
				System.out.println("***Invalid selection***");
			}
		} while (consoleInput != "bye");
		return menu;
	}

	private PhoneContacts submenuList(PhoneContacts menu) {
		PhoneContacts ret = null;
		System.out.println("***Submenu List***");
		@SuppressWarnings("unused")
		String consoleInput;
		ret = menu.mainMenu(menu);
		return ret;
	}

	private PhoneContacts submenuNew(PhoneContacts menu) {
		PhoneContacts ret = null;
		System.out.println("***Submenu New***");
		@SuppressWarnings("unused")
		String consoleInput;
		return ret;
	}

	private PhoneContacts submenuAdd(PhoneContacts menu) {
		PhoneContacts ret = null;
		System.out.println("***Submenu Add***");
		@SuppressWarnings("unused")
		String consoleInput;
		ret = menu.mainMenu(menu);
		return ret;
	}

	private PhoneContacts submenuModify(PhoneContacts menu) {
		PhoneContacts ret = null;
		System.out.println("***Submenu Modify***");
		@SuppressWarnings("unused")
		String consoleInput;
		ret = menu.mainMenu(menu);
		return ret;
	}

	private PhoneContacts submenuDelete(PhoneContacts menu) {
		PhoneContacts ret = null;
		System.out.println("***Submenu Delete***");
		@SuppressWarnings("unused")
		String consoleInput;
		ret = menu.mainMenu(menu);
		return ret;
	}
}
