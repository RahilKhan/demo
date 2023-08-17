/**
 *
 */
package com.example.demo.dummy;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Empl;
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
        employeeList.add(new Employee(1, "John", 80000.0, 32, "Male", "Product Development", 2014));
        employeeList.add(new Employee(2, "Jack", 90000, 34, "Male", "Product Development", 2014));
        employeeList.add(new Employee(3, "Ricky", 120000, 34, "Male", "Product Development", 2014));


        return employeeList;

    }

    public static List<Empl> getDummyEmpl() {
        List<Empl> employeeList = new ArrayList<>();

        Empl empl = new Empl();
        empl.setName("Jiya Brein");
        empl.setAge(32);
        empl.setSalary(25000.0);
        employeeList.add(empl);

        empl = new Empl();
        empl.setName("Paul Niksui");
        empl.setAge(25);
        empl.setSalary(13500.0);
        employeeList.add(empl);

        empl = new Empl();
        empl.setName("John");
        empl.setAge(32);
        empl.setSalary(80000.0);
        employeeList.add(empl);

        empl = new Empl();
        empl.setName("Nima Roy");
        empl.setAge(27);
        empl.setSalary(22700.0);
        employeeList.add(empl);

        empl = new Empl();
        empl.setName("Murali Gowda");
        empl.setAge(27);
        empl.setSalary(32500.0);
        employeeList.add(empl);

        empl = new Empl();
        empl.setName("Martin Theron");
        empl.setAge(29);
        empl.setSalary(18000.0);
        employeeList.add(empl);

        empl = new Empl();
        empl.setName("");
        empl.setAge(29);
        empl.setSalary(18000.0);
        employeeList.add(empl);

        return employeeList;

    }
}
