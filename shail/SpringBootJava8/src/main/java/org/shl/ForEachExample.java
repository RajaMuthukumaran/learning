package org.shl;

import java.util.List;

import org.shl.pojo.Person;

public class ForEachExample {
	public List<Person> increaseAgeBy5(List<Person> persons){
		persons.forEach(p -> p.setAge(p.getAge()+5));
		return persons;
	}
}
