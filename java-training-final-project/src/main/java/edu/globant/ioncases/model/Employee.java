/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model;




/**
 *
 * @author fedec
 */
public abstract class Employee {
    
    private String fullname;
    private String jobTitle;

    public Employee(String fullname, String jobTitle) {
        this.fullname = fullname;
        this.jobTitle = jobTitle;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


    
    


    
}
