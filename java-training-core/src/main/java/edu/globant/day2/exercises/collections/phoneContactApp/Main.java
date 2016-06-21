/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day2.exercises.collections.phoneContactApp;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        String opt;

            do {
                System.out.println("1) List contacts");
                System.out.println("2) List fav contacts");
                System.out.println("3) New contact");
                System.out.println("4) Edit contact");
                System.out.println("5) Delete contact");
                System.out.println("6) Exit");

                System.out.println("\n Select option: ");

                
                try {
                    opt = scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("--> Exeption: " + e);
                    opt = "";
                }
                
                switch (opt) {
                    case "1":
                        listContacts(listContacts);
                        break;
                    case "6":
                        System.out.println("Exit...");
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }

            } while (!"6".equals(opt));

        }

    

    private static void defaultListContact(List<Contact> contacts) {
        
        Category family = new Category("Family");
        Category friends = new Category("Friends");
        Category emergency = new Category("Emergency");
        

        Contact contact1 = new Contact("Federico Gaston Calarco", "fede.calarco@globant.com");
        contact1.addPhoneNumber("2804722352");
        contact1.addPhoneNumber("221258808");
        contact1.addPhoneNumber("2804722352");
        contact1.setCategory(friends);
        contacts.add(contact1);
        
        
        Contact police = new Contact("Police","police@emergency.com");
        police.addPhoneNumber("101");
        police.setCategory(emergency);
        contacts.add(police);
        
        
        Contact contact2 = new Contact("A Homer Simpsons","homer.simpsons@gmail.com");
        contact2.addPhoneNumber("54216551");
        contact2.setCategory(friends);
        contacts.add(contact2);
    }

    private static void listContacts(List<Contact> listContacts) {
        System.out.println("----- LIST CONTACTS -----");
        listContacts.forEach(contact -> showContact(contact));
    }

    private static void showContact(Contact contact) {

        System.out.print(String.format("\n %s - %s", contact.getFullname(),contact.getMail()));
        contact.getPhoneNumber().stream().forEach((phone) -> {
            System.out.print(" - " + phone);
        });
        System.out.println("\n");
        

    }
}
