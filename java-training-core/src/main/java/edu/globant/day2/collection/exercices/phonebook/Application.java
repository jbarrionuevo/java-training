package edu.globant.day2.collection.exercices.phonebook;

public class Application {
	
	public static void main(String[] args) {
		PhoneBookService phoneService = new PhoneBookService();
		
		System.out.println("-----------------------Contacts------------------------------");
		phoneService.showContacts();
		System.out.println(" ");
		System.out.println("-------------------Last Contacts Added------------------------------");
		phoneService.showLastContactsAdded();
		System.out.println(" ");
		System.out.println("-------------------Messages By Date------------------------------");
		phoneService.showMessagesByDate();
		System.out.println(" ");
		System.out.println("-------------------Last Messages First------------------------------");
		phoneService.showLastMessagesFirst();
		phoneService.addContactToGroup("WHATSAPP", "Pablo");
		phoneService.addContactToGroup("WHATSAPP", "Luciana");
		phoneService.addContactToGroup("WHATSAPP", "Carlos");
		phoneService.addContactToGroup("WORK", "Marina");
		phoneService.addContactToGroup("WORK", "Mario");
		System.out.println(" ");
		System.out.println("-------------------Contacts By Group------------------------------");
		phoneService.showContactsByGroup();
	}

}
