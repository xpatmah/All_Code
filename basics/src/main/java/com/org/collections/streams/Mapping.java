package com.org.collections.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.org.domain.collection.Employee;
import com.org.domain.collection.Trade;
import com.org.domainhandlerUtil.EmployeeUtil;
import com.org.domainhandlerUtil.TradeUtil;

public class Mapping {
	
	List<Employee> employees = EmployeeUtil.createEmployees();
	
	List<Employee> detailedEmployee = EmployeeUtil.createDetailedEmployees();
	
	List<Trade> tradeList = TradeUtil.createTrades();

	public static void main(String[] args) {
		new Mapping().testGroupingBy();
	}
	
	private void testMapping() {
		Stream<String> empName = employees.stream().map(Employee::getName);
		
		empName.forEach(System.out::println);
		
		//Map<String , Employee> empMap = employees.stream().collect(Collectors.toMap(Employee::getName, e -> e));
		
		Optional<String> findFirst = employees.stream().map(Employee::getName).filter(e -> e.startsWith("Ki")).findFirst();
		
		System.out.println(findFirst.get());
		
		System.out.println(tradeList.stream().map(e -> e.getQuantity()).reduce((a,b)-> a+b));
		
		Supplier<ArrayList<Integer>> arrayList =  ArrayList<Integer>::new;
		ArrayList<Integer> intList = arrayList.get();
		intList.add(34);
		System.out.println(intList);
	}
	
	public void testGroupingBy() {
		Map<String , List<Employee>> empMap =  employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment()));
		
		Map<String , Map<String , List<Employee>>> empGrouping = detailedEmployee.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.groupingBy(Employee::getCity)));
		
		System.out.println(empMap);
		
		System.out.println(empGrouping);
		
	}
	
	
}
