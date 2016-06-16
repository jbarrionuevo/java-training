/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day2.exercises.PhoneContactApp;

import java.util.List;

/**
 *
 * @author federico.calarco
 */
public class Contact {
    private String fullname;
    private List<String> phoneNumber ;
    private String mail;

    public Contact(String fullname, List<String> phoneNumber, String mail) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    
    
    
}
