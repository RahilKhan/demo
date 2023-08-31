package com.example.demo.coding;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.demo.dummy.DummyEmployee;
import com.example.demo.model.Employee;

/**
 * @author Rahil_Khan
 */
public class CodingExercise {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] array = {1, 2, 3, -1, -2, 4};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        reverseLinkList();
    }

    private static void reverseLinkList() {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(2);
        ll.add(3);

        System.out.println(ll);
        LinkedList<Integer> ll1 = new LinkedList<>();

        ll.descendingIterator().forEachRemaining(ll1::add);
        System.out.println(ll1);

        SecondHighestSalary();
    }

    /* 2n highest salary */
    private static void SecondHighestSalary() {

        List<Employee> empList = DummyEmployee.getDummyEmployeeList();
//		empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary))

        System.out.println("--------------sortedEmployees----------------");
        List<Employee> sortedEmployees = empList.stream().sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toList());
        sortedEmployees.forEach(item -> System.out.println(item));

        System.out.println("--------------sortedEmpBySal----------------");
        List<Employee> sortedEmpBySal = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        sortedEmpBySal.forEach(item -> System.out.println(item));

        System.out.println("---------------empLst---------------");
        Employee employee = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList()).get(1);
//		System.out.println("Employee sorted reversed : " + empLst.toString());
        System.out.println("Employee with second highest salary : " + employee);

        System.out.println("---------------emp---------------");
        Optional<Employee> emp = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1).findFirst();
        System.out.println("Inline -> Employee with second highest salary : " + emp.get());

        Map employeeMap = empList.stream().collect(Collectors
                        .toMap(Employee::getSalary,
                                Function.identity(),
                                (a, b) -> a,
                                () -> new TreeMap<>(Comparator.comparing(Double::doubleValue).reversed())));

        System.out.println("TreeMap -> : " + employeeMap);

        employee = empList.stream().collect(Collectors
                .toMap(Employee::getSalary,
                        Function.identity(),
                        (a, b) -> a,
                        () -> new TreeMap<>(Comparator.comparing(Double::doubleValue).reversed())))
                .values().stream().skip(1).findFirst().orElse(null);

        System.out.println("TreeMap -> Employee with second highest salary : " + employee);
    }

}
