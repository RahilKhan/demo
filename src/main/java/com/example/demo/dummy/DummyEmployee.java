/**
 * 
 */
package com.example.demo.dummy;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Employee;

/**
 * @author Rahil_Khan
 *
 */
public class DummyEmployee {

	public static List<Employee> getDummyEmployee() {
		List<Employee> employeeList = new ArrayList<>();
		
		employeeList.add(new Employee(111, "Jiya Brein", 25000.0, 32, "Female", "HR", 2011));
		employeeList.add(new Employee(122, "Paul Niksui", 13500.0, 25, "Male", "Sales And Marketing", 2015));
		employeeList.add(new Employee(133, "Martin Theron", 18000.0, 29, "Male", "Infrastructure", 2012));
		employeeList.add(new Employee(144, "Murali Gowda", 32500.0, 28, "Male", "Product Development", 2014));
		employeeList.add(new Employee(155, "Nima Roy", 22700.0, 27, "Female", "HR", 2013));
		employeeList.add(new Employee(1,   "John",     80000.0, 32, "Male", "Product Development", 2014));
		employeeList.add(new Employee(2, "Jack", 90000, 34, "Male", "Product Development", 2014));
		employeeList.add(new Employee(3, "Ricky", 120000, 34, "Male", "Product Development", 2014));
		
		
		return employeeList;
	
	}
}
