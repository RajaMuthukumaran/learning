package com.tutorial.java8.lambda;

import java.time.LocalDate;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;
    
    public Person(String name, int age, String emailAddress, Person.Sex sex){
    	this.name=name;
    	this.age=age;
    	this.emailAddress=emailAddress;
    	this.gender = sex;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person.Sex getGender(){
    	return gender;
    }
    
    public String getEmailAddress() {
    	return emailAddress;
    }
    public int getAge() {
        // ...
    	return age;
    }

    public void printPerson() {
        // ...
    	System.out.println("Person[Name :"+name+"]");
    }
}