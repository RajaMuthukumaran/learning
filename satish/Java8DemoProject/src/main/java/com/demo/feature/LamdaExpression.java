package com.demo.feature;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class LamdaExpression {
	public static void main(String args[]) {

		List<String> names1 = new ArrayList<>();
		names1.add("Sailender");
		names1.add("Raja");
		names1.add("Satish");

		List<String> projects = new ArrayList<>();
		
		projects.add("BBQ");
		projects.add("Rock");
		projects.add("BumbleB");

		LamdaExpression lamdas = new LamdaExpression();
		
		System.out.println("List:"+ names1);

		lamdas.sortUsingJava7manner(names1);
		
		System.out.println("Sort using Java 7 syntax:"+ names1);
  
		
		lamdas.sortUsingJava8manner(names1);
		
		System.out.println("Sort using Java 8 syntax:"+ names1);
	}

	private void sortUsingJava8manner(List<String> names1) {
		Collections.sort(names1,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
	}

	private void sortUsingJava7manner(List<String> names1) {
		Collections.sort(names1, (o1, o2) -> o1.compareTo(o2));
	}
}
