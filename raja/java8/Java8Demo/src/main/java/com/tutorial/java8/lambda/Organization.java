package com.tutorial.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import static java.util.stream.Collectors.*;

public class Organization {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Mahesh", 30, "Mahesh@test.com", Person.Sex.MALE));
		persons.add(new Person("Suresh", 20, "Mahesh@test.com", Person.Sex.MALE));
		persons.add(new Person("Ramesh", 40, "Mahesh@test.com", Person.Sex.MALE));
		persons.add(new Person("Raja", 33, "Mahesh@test.com", Person.Sex.MALE));
		persons.add(new Person("Naresh", 40, "Mahesh@test.com", Person.Sex.MALE));
		persons.add(new Person("Arthi", 12, "arthi@test.com", Person.Sex.FEMALE));

		persons.forEach(e -> {
			if (e.getGender() == Person.Sex.MALE && e.getAge() > 25) {
				e.printPerson();
			}
		});

		persons.stream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
				.map(p -> p.getEmailAddress()).forEach(email -> System.out.println(email));

		persons.stream().filter(p -> p.getGender() == Person.Sex.MALE).filter(p -> p.getAge() >= 18 && p.getAge() <= 25)
				.map(p -> p.getEmailAddress()).forEach(email -> System.out.println(email));

		Predicate<Person> maleOnly = p -> p.getGender() == Person.Sex.MALE;
		Predicate<Person> ageRange = p -> p.getAge() >= 18 && p.getAge() <= 25;

		persons.stream().filter(maleOnly).filter(ageRange).map(p -> p.getEmailAddress())
				.forEach(email -> System.out.println(email));

		// max function
		Person p = persons.stream()
				// .filter(maleOnly)
				// .filter(ageRange)
				.max(Comparator.comparing(Person::getAge)).get();

		p.printPerson();

		List<Integer> integers = new ArrayList<Integer>();
		integers.add(new Integer(10));
		integers.add(new Integer(1230));
		integers.add(new Integer(2332));
		integers.add(new Integer(3454));
		integers.add(new Integer(3434));
		integers.add(new Integer(5));

		Integer sum = integers.stream().reduce(50000, (a, b) -> a + b);
		System.out.println(sum);

		// Integer sum1 = integers.reduce(0, Integer::sum);
		IntSummaryStatistics summary = getStats(persons);
		System.out.println(summary.toString());

		System.out.println(partitionAdults(persons));
		System.out.println(groupByGender(persons));
		System.out.println(getAllPersonNames(persons));

	}

	public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}
	}

	public static IntSummaryStatistics getStats(List<Person> people) {
		return people.stream().mapToInt(Person::getAge).summaryStatistics();
	}

	public static Map<Boolean, List<Person>> partitionAdults(List<Person> persons) {
		return persons.stream() // Convert collection to Stream
				.collect(partitioningBy(p -> p.getAge() >= 18)); // Partition
																	// stream of
																	// people
																	// into
																	// adults
																	// (age =>
																	// 18) and
																	// kids
	}

	public static Map<Person.Sex, List<Person>> groupByGender(List<Person> persons) {
		return persons.stream() // Convert collection to Stream
				.collect(groupingBy(Person::getGender)); // Group people by
															// nationality
	}

	public static String getAllPersonNames(List<Person> persons) {
		return persons.stream() // Convert collection to Stream
				.map(Person::getName).collect(joining(";", "Person Name:-[", "]")); // Group
																					// people
																					// by
																					// name
	}

}
