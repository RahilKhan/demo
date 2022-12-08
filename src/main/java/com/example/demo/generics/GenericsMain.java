package com.example.demo.generics;

import com.example.demo.model.Employee;

/**
 * @author Rahil_Khan
 *
 */
public class GenericsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Employee employee = new Employee(1001, "GenericMainClass", 1000);
		GenericClass genC = new GenericClass(employee);
		Employee empl = (Employee) genC.respond();
		
		System.out.println("Employee Id     : " + empl.getId());
		System.out.println("Employee Name   : " + empl.getName());
		System.out.println("Employee Salary : " + empl.getSalary());

	}

}
