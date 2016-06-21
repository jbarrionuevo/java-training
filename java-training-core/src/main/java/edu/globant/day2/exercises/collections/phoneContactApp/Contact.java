/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day2.exercises.collections.phoneContactApp;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author federico.calarco
 */
public class Contact {
    private String fullname;
    private Set<String> phoneNumber = new HashSet();
    private String mail;

    public Contact() {
    }

    public Contact(String fullname, Set<String> phoneNumber, String mail) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public Contact(String fullname, String mail) {
        this.fullname = fullname;
        this.mail = mail;
    }
    
    

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Set<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Set<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public void addPhoneNumber(String number){
        this.phoneNumber.add(number);
    }

    
    
    
}
