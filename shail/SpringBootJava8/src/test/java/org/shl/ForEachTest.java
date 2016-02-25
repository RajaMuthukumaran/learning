package org.shl;

import java.util.ArrayList;
import java.util.List;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.shl.ForEachExample;
import org.shl.pojo.Person;

public class ForEachTest {
	List<Person> persons=new ArrayList<Person>();
	
	@Before
	public void init(){
		persons.add(new Person("shailendra",32));
		persons.add(new Person("Raja",33));
		persons.add(new Person("Satish",30));
	}
	@Test
	public void whenInvokeIncreaseAgeBy5ThenShouldReturnModifiedAge(){
		ForEachExample f1=new ForEachExample();
		List<Person> result=f1.increaseAgeBy5(persons);
		result.forEach(p -> Assert.assertEquals(p.getAge(),p.getPrevAge()+5));
	}
}
