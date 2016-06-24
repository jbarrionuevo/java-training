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
public class Customer {
    
    private int id;
    private String name;
    private int age;
    private char gender;
    private String location;

    
    public Customer(String name, int age, char gender, String location) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", location=" + location + '}';
    }


    
    
}
