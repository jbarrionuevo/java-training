/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day2.exercises.PhoneContactApp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author federico.calarco
 */
public class ContactList {
    
    public static void main(String[] args) {
        
        List<Contact> contactList = new ArrayList<>();
        
        ArrayList<String> numbers = new ArrayList<>();
        
        
        numbers.add("4451523");
        numbers.add("445512");
        Contact contact1 = new Contact("Federico", numbers, "federico.calarco@globant.com");
        
 
        // 
        
        Contact contact2 = new Contact("Pepe", numbers, "pepe@mail.com");
        
        
        contactList.add(contact1);
        contactList.add(contact2);
        
        for(Contact contact : contactList){
            System.out.println(contact.getFullname() + " - " + contact.getPhoneNumber() + " - " + contact.getMail());
        }
        
       
        
    }
    
}
