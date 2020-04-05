package com.org.collections.streams;

import java.util.function.Consumer;
import java.util.function.Predicate;

import com.org.domain.collection.Employee;

public class PredicateTest {

	public static void main(String[] args) {
		
		Predicate<Employee> empSala = (emp) -> emp.getDepartment().endsWith("A");
		
		Predicate<Employee> empName = (emp) -> emp.getName().startsWith("Lo");
		
		Predicate<Employee> andPredicate = empSala.and(empName);
		
		Consumer<Employee> consumer = System.out::println;
		
		Consumer<Employee> andThenCon = System.out::println;
		
		Consumer<Employee> andthe = andThenCon.andThen(consumer);
		
		Employee enp = new Employee(1);
		enp.setName("Local");
		enp.setDepartment("A");
		andthe.accept(enp);
		
		System.out.println(andPredicate.test(enp));
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
