package com.example.demo.javafeatures.sorting;

import com.example.demo.model.dummy.DummyEmployee;
import com.example.demo.model.Empl;
import com.example.demo.model.Employee;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Sorting:
 * #1. List sorting -> list.sort(...)
 *      empList.sort(employeeNameComparator)
 *      employeeList.sort(Comparator.comparing(Employee::getName));
 *      employeeList.sort(Comparator.comparing(Employee::getName).reversed());
 * <p>
 * #2  Collection sorting -> Collection.sort(...)
 *      e.g Collection.sort(<list/array>, customComparator)
 *      Collections.sort(employeeList, Comparator.comparing(Employee::getName));
 *      Collections.sort(employeeList, Comparator.comparing(Employee::getName).reversed());
 * <p>
 * #3  Array sorting -> Arrays.sort()...
 *      e.g #1. Arrays.sort(empArr, employeeNameComparator);
 *      Arrays.sort(empArr, employeeNameComparator.reversed());
 * #3.1. Arrays.sort(<primitive Array>);
 *      Arrays.sort(intArr);
 * #3.2 Integer[] reverse sort
 *      Arrays.sort(numbers, Collections.reverseOrder());
 *      Note: numbers -> Integer[] not primitive int[].
 *           Integer[] numbers = {5, 1, 9, 3, 7};
 *      Collections.reverseOrder() -> does not work on primitive int[]
 * #4 Stream ->
 *      List<Employee> empList = (List<Employee>) list.stream()
 *              .sorted(Comparator.comparing(Employee::getName))
 *              .collect(Collectors.toList());
 */
@Slf4j
public class ComparingExample {


    public static void main(String... args) {
        System.out.println("\n------------sortingEmployeeArray------------");
//        sortingEmployeeArray();

        System.out.println("\n------------sortingPrimitiveArray------------");
        sortingPrimitiveArray();

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

        Employee[] empArr = DummyEmployee.getDummyEmployeeArray();
//        Arrays.sort(empArr);
//        System.out.println("Arrays.sort(empArr) : " + empArr);

        Arrays.sort(empArr, ComparingExample.SalaryComparator);
        System.out.println("Arrays.sort(empArr, ComparingExample.SalaryComparator) : ");
        Arrays.stream(empArr).forEach(System.out::println);

        Arrays.sort(empArr, ageComaprator);
        System.out.println("Arrays.sort(empArr, ageComaprator) : ");
        Arrays.stream(empArr).forEach(System.out::println);
    }


    public static void sortingEmployeeArray() {
        List<Employee> employees = DummyEmployee.getDummyEmployeeList();

        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);

        Employee[] empArr = employees.toArray(Employee[]::new);
        Arrays.sort(empArr, employeeNameComparator);

        Stream.of(empArr).map(Employee::getName).forEach(System.out::println);

        System.out.println("\n------------sortingEmployeeArray - reversed()------------");
        Arrays.sort(empArr, employeeNameComparator.reversed());
        Stream.of(empArr).map(Employee::getName).forEach(System.out::println);
        //Collections.sort(empArr, employeeNameComparator.reversed()); /*Applicable on list,set*/
    }

    public static void sortingPrimitiveArray() {
        System.out.println("\n------------sortingPrimitiveArray - sorted()------------");
        int[] numbers = {5, 2, 9, 7, 0, -1, 3, 13, -11};
        Arrays.sort(numbers);
        IntStream.of(numbers).forEach(System.out::println);

        /**Note
         * Convert primitive int[] to class Integer[].
         * Required to apply Collections.reverseOrder()
         */
        Integer[] intArray = IntStream.of(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(intArray, Collections.reverseOrder());
        Stream.of(intArray).forEach(System.out::println);

    }


    public static void sortingEmployeeArrayCustomSort() {
        List<Employee> employees = DummyEmployee.getDummyEmployeeList();

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
     * Orignal Empl class needs to implement Comparable
     */
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

        List<Employee> employeeList = DummyEmployee.getDummyEmployeeList();
        employeeList.sort(Comparator.comparing(Employee::getName));
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

        employeeList = DummyEmployee.getDummyEmployeeList();
        Collections.sort(employeeList, Comparator.comparing(Employee::getName).reversed());
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

    }

    public static void sortingEmployeeListReversed() {

        List<Employee> employeeList = DummyEmployee.getDummyEmployeeList();
        employeeList.sort(Comparator.comparing(Employee::getName).reversed());
        employeeList.stream().map(Employee::getName).forEach(System.out::println);

    }

    /**
     * Comparator to sort employees list or array in order of Salary
     */
    public static Comparator<Employee> ageComaprator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getAge() - o2.getAge();
        }
    };

    /**
     * Comparator to sort employees list or array in order of Salary
     */
    public static Comparator<Employee> SalaryComparator = (e1, e2) -> (int) (e1.getSalary() - e2.getSalary());

}
