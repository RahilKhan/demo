package com.example.demo.java8;

import com.example.demo.dummy.DummyEmployee;
import com.example.demo.model.Empl;
import com.example.demo.model.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


/**
 * Sorting:
 * #1. List sorting -> list.sort(...)
 *      empList.sort( empList, employeeNameComparator)
 *      employeeList.sort(Comparator.comparing(Employee::getName));
 *      employeeList.sort(Comparator.comparing(Employee::getName).reversed());
 *
 * #2  Collection sorting -> Collection.sort(...)
 *      e.g Collection.sort(<list/array>, customComparator)
 *          Collections.sort(employeeList, Comparator.comparing(Employee::getName));
 *          Collections.sort(employeeList, Comparator.comparing(Employee::getName).reversed());
 *
 * #3  Array sorting -> Arrays.sort()...
 *      e.g Arrays.sort(empArr, employeeNameComparator);
 *          Arrays.sort(empArr, employeeNameComparator.reversed());
 */
public class ComparingExample {



    public static void main(String... args) {
        System.out.println("\n------------sortingEmployeeArray------------");
        sortingEmployeeArray();

        System.out.println("\n------------sortingEmployeeArrayCustomSort------------");
        sortingEmployeeArrayCustomSort();

        System.out.println("\n------------sortingEmployeeArrayByNaturalOrder------------");
        sortingEmployeeArrayByNaturalOrder();

        System.out.println("\n------------sortingEmployeeArrayByReverseOrder------------");
        sortingEmployeeArrayByReverseOrder();

        System.out.println("\n------------sortingEmployeeList------------");
        sortingEmployeeList();

        System.out.println("\n------------sortingEmployeeListReversed------------");
        sortingEmployeeListReversed();
    }


    public static void sortingEmployeeArray() {
        List<Employee> employees = DummyEmployee.getDummyEmployee();

        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);

        Employee[] empArr = employees.toArray(Employee[]::new);
        Arrays.sort(empArr, employeeNameComparator);

        Stream.of(empArr).map(Employee::getName).forEach(System.out::println);

        System.out.println("\n------------sortingEmployeeArray - reversed()------------");
        Arrays.sort(empArr, employeeNameComparator.reversed());
        Stream.of(empArr).map(Employee::getName).forEach(System.out::println);
    }

    public static void sortingEmployeeArrayCustomSort() {
        List<Employee> employees = DummyEmployee.getDummyEmployee();

        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName, (a, b) -> {
            return a.compareTo(b);
        });

        Employee[] empArr = employees.toArray(Employee[]::new);
        Arrays.sort(empArr, employeeNameComparator);

        Stream.of(empArr).map(Employee::getName).forEach(System.out::println);

    }

    /**
     * Invasive strategy:
     * Requires modifying original class.
     * Orignal Empl class needs to implement Comparable*/
    public static void sortingEmployeeArrayByNaturalOrder() {
        List<Empl> employees = DummyEmployee.getDummyEmpl();
        Empl[] empArr = employees.toArray(Empl[]::new);

        Comparator<Empl> empNameComparator = Comparator.<Empl>naturalOrder();
        Arrays.sort(empArr, empNameComparator);

        Stream.of(empArr).map(Empl::getName).forEach(System.out::println);


    }

    public static void sortingEmployeeArrayByReverseOrder() {
        List<Empl> employees = DummyEmployee.getDummyEmpl();
        Empl[] empArr = employees.toArray(Empl[]::new);

        Comparator<Empl> empNameComparator = Comparator.<Empl>reverseOrder();
        Arrays.sort(empArr, empNameComparator);

        Stream.of(empArr).map(Empl::getName).forEach(System.out::println);


        employees.add(null);
        employees.add(null);
        Empl[] empArr1 = employees.toArray(Empl[]::new);

        Comparator<Empl> empNameComparatorNullsFirst = Comparator.nullsFirst(empNameComparator);
        Arrays.sort(empArr1, empNameComparatorNullsFirst);
        Stream.of(empArr1).forEach(System.out::println);


    }

    public static void sortingEmployeeList() {

        List<Employee> employeeList = DummyEmployee.getDummyEmployee();
        employeeList.sort(Comparator.comparing(Employee::getName));
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

        employeeList = DummyEmployee.getDummyEmployee();
        Collections.sort(employeeList, Comparator.comparing(Employee::getName).reversed());
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

    }

    public static void sortingEmployeeListReversed() {

        List<Employee> employeeList = DummyEmployee.getDummyEmployee();
        employeeList.sort(Comparator.comparing(Employee::getName).reversed());
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

    }


}
