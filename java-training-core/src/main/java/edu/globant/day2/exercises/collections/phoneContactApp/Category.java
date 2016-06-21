/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day2.exercises.collections.phoneContactApp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author federico.calarco
 */
public class Category {
    
    private String name;
    private List<Contact> contacts = new ArrayList<>();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    
    
    
    
}
