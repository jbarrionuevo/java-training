/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day2.exercises.collections.phoneContactApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fedec
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Contact> listContacts = new ArrayList<Contact>();

    public static void main(String[] args) {

        defaultListContact(listContacts);
        System.out.println("Phone contacts");
        menu();

    }

    private static void menu() {
        int opt;

        do {
            System.out.println("1) List contacts");
            System.out.println("2) List fav contacts");
            System.out.println("3) New contact");
            System.out.println("4) Edit contact");
            System.out.println("5) Delete contact");
            System.out.println("6) Exit");

            System.out.println("\n Select option: ");

            opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    listContacts(listContacts);
                    break;
                case 6:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        } while (opt != 6);
    }

    private static void defaultListContact(List<Contact> contacts) {

        Contact contact1 = new Contact("Federico Gaston Calarco", "fede.calarco@globant.com");
        contact1.addPhoneNumber("2804722352");
        contact1.addPhoneNumber("221258808");
        contact1.addPhoneNumber("2804722352");

        contacts.add(contact1);

    }

    private static void listContacts(List<Contact> listContacts) {

        listContacts.forEach(contact -> showContact(contact));
    }

    private static void showContact(Contact contact) {

        System.out.println("--------------------------------------------");
        System.out.println(String.format("Fullname: %s ", contact.getFullname()));
        System.out.println(String.format("Mail: %s ", contact.getMail()));
        System.out.println("Phones: ");
        contact.getPhoneNumber().stream().forEach((phone) -> {
            System.out.println(phone);
        });
        
    }
}
