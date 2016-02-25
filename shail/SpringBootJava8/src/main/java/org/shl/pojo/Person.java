package org.shl.pojo;

public class Person {
	String name;
	int age;
	int prevAge;
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
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
		this.prevAge=this.age;
		this.age = age;
	}
	public int getPrevAge() {
		return prevAge;
	}
	public void setPrevAge(int prevAge) {
		this.prevAge = prevAge;
	}
	
	
}
