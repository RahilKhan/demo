package com.example.demo.javafeatures.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.demo.model.Employee;


public class StreamListToMap {

	public static void main(String... args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "John", 80000, 0, null, null, 0));
		list.add(new Employee(2, "Jack", 90000, 0, null, null, 0));
		list.add(new Employee(3, "Ricky", 120000, 0, null, null, 0));

		// key = id, value - name
		Map<Integer, String> result1 = list.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
		System.out.println("result1 : " + result1 + "\n result1.isEmpty() : " + result1.isEmpty());

		Map<Integer, List<Integer>> result2 = list.stream().collect(
				Collectors.groupingBy(Employee::getId, Collectors.mapping(Employee::getId, Collectors.toList())));
		System.out.println("result2 : " + result2 + "\n result2.isEmpty() : " + result2.isEmpty());

		List<Employee> emptyList = new ArrayList<>();
		Map<Integer, List<Integer>> result3 = emptyList.stream().collect(
				Collectors.groupingBy(Employee::getId, Collectors.mapping(Employee::getId, Collectors.toList())));
		System.out.println("result3 : " + result3 + "\n result3.isEmpty() : " + result3.isEmpty());
		

		list.stream().sorted(Comparator.comparing(Employee::getName))
				 .collect(Collectors.toList());
		System.out.println("\nsorted list : " + list.toString());

		
		List<Employee> empList = (List<Employee>) list.stream().sorted(Comparator.comparing(Employee::getName))
				 .collect(Collectors.toList());
		System.out.println("\nempList list : " + empList.toString());

		float avgPrice = 0;
		System.out.println("\navgPrice : " + avgPrice);

		Object obj = new Object();
		if(obj instanceof Employee){
			Employee emp =  (Employee)obj;
			emp.getSalary();
		}

		if( obj instanceof Employee emp){
			emp.getSalary();
		}

		
	}

}
