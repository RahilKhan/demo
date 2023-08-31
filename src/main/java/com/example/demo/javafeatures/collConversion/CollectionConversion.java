package com.example.demo.javafeatures.collConversion;

import com.example.demo.dummy.DummyEmployee;
import com.example.demo.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionConversion {

    public static void main(String... args) {
        arrayConversion();
        listConversion();
        setConversion();
    }

    /**
     * Conversion
     * Array -> List
     * Array -> Set
     */
    public static void arrayConversion() {
        Employee[] empArr = DummyEmployee.getDummyEmployeeArray();

        System.out.println("\n-------Conversion Array -> List-------");

        /** Best approach */
        List<Employee> employeeList = Arrays.stream(empArr).toList();
        System.out.println("\t employeeList : " + employeeList);

        /** ArrayList returned by Array belong to Array class and not to List class.
         *  As such ArrayList from Array is not modifiable.
         * It needs to be type-casted or stored in java.util.ArrayList
         * better alt:
         *  employeeList = Arrays.asList(empArr);
         *  where employeeList -> java.util.ArrayList */
        List<Employee> empList = Arrays.asList(empArr);
        System.out.println("\t empList : " + empList);


        System.out.println("\n-------Conversion Array -> Set-------");

        /** Best approach */
        Set<Employee> employeeSet = Arrays.stream(empArr).collect(Collectors.toSet());
        System.out.println("\t employeeSet : " + employeeSet);

        Set<Employee> empSet = new HashSet<>(Arrays.asList(empArr));
        System.out.println("\t empSet : " + empSet);
    }

    public static void listConversion() {

        List<Employee> employeeList = DummyEmployee.getDummyEmployee();

        System.out.println("\n-------Conversion List -> Array-------");
        /** Best approach */
        Employee[] employeeArr = employeeList.stream().toArray(Employee[]::new);
        System.out.println("\t employeeArr : " + employeeArr);

        /** Explicit type casting required*/
        Employee[] empArr = employeeList.toArray(new Employee[0]);
        System.out.println("\t empArr : " + empArr);


        System.out.println("\n-------Conversion List -> Set-------");

        /** employeeList.stream().toSet() -> does not exist */
        Set employeeSet = employeeList.stream().collect(Collectors.toSet());
        System.out.println("\t employeeSet : " + employeeSet);

        Set empSet = new HashSet<>(employeeList);
        System.out.println("\t empSet : " + empSet);
    }

    public static void setConversion() {

        Set<Employee> employeeSet = DummyEmployee.getDummyEmployeeSet();

        System.out.println("\n-------Conversion Set -> List-------");

        /** Best approach */
        List<Employee> employeeList = employeeSet.stream().toList();
        System.out.println("\t employeeList : " + employeeList);

        List<Employee> empList = new ArrayList<>(employeeSet);
        System.out.println("\t empList : " + empList);


        System.out.println("\n-------Conversion Set -> Array-------");

        /** Best approach */
        Employee[] employeesArray =  employeeSet.stream().toArray(Employee[] ::new);
        System.out.println("\t employeesArray : " + employeesArray);

        Employee[] empArray = employeeSet.toArray(new Employee[0]);
        System.out.println("\t empArray : " + empArray);
//        Arrays.stream(employeesArray).forEach(System.out::println);

        /* Method reference style*/
        empArray = employeeSet.toArray(Employee[]::new);
        System.out.println("\t empArray : " + empArray);


    }
}
