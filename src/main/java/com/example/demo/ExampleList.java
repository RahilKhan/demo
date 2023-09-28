package com.example.demo;

import com.example.demo.model.Empl;
import com.example.demo.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

;import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class ExampleList {
//    List no -> x*100 ->sort -> reverse

    public static void main(String... args) {

        List<Integer> intList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            intList.add(random.nextInt(50));
        }

        System.out.println("------- Stream.generate(Math::random) -------");
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        System.out.println("------- random.ints(50).limit(10) -------");
        IntStream intStream = random.ints(50);
        random.ints(50).limit(10).forEach(System.out::println);
        List<Integer> integerList1 = random.ints(50,100).limit(10).boxed().toList();
        List<Integer> integerList2 = random.ints(10,50,100).boxed().toList();

        System.out.println("------- integerList1.size() : " + integerList1.size());
        integerList1.forEach(System.out::println);

        System.out.println("------- integerList2.size() : " + integerList2.size());
        integerList2.forEach(System.out::println);
//        Stream.generate(random::nextInt).limit(10).forEach(System.out::println);

        List<Integer> intListSorted = intList.stream().map(x -> x * 100).sorted().collect(Collectors.toList());
        Collections.sort(intListSorted, Collections.reverseOrder());
        //intListSorted.sort(Collections.reverseOrder());
        System.out.println("intListSorted : " + intListSorted);

        List<Integer> intListSorted1 = intList.stream().map(x -> x * 100).sorted().collect(Collectors.toList());
        System.out.println("------- intListSorted1 -------");
        intListSorted1.forEach(System.out::println);
        intListSorted1.sort(Comparator.reverseOrder());
        System.out.println("intListSorted1 : " + intListSorted1);


        HashMap hm = new HashMap();
        Empl emp = new Empl();
        System.out.println("emp : " + emp);

        hm.put(emp, "a");
        System.out.println("hm : " + hm);
        System.out.println("hm.get(emp) : " + hm.get(emp));
        //hm.get(emp) : a

        emp = null;
        hm.put(emp, "b");
        System.out.println("hm : " + hm);
        //hm : {null=b, Empl(name=null, age=null, salary=null)=a}
        System.out.println("hm.get(emp) : " + hm.get(emp));
        //hm.get(emp) : b

        HashSet hs = new HashSet();
        hs.add(null);
        System.out.println("hs : " + hs);

        String[] vowels = {"a", "e", "i", "o", "u"};
        Set<String> vowelsSet = new HashSet<>();
        Collections.addAll(vowelsSet, vowels);
        System.out.println(vowelsSet);

        //Collections.addAll(hm,vowels); //does not work.

        displayEmployee();

        System.out.println();
        isSubsequence("ace", "ahbgdc");
        isSubsequence("a", "b");
        isSubsequence("b", "a");

        String s = "ace";
        String t = "ahbgdc";
        System.out.println("s : " + s + " :: t : " + t + " -> " + isSubsequence(s, t));

        s = "a";
        t = "b";
        System.out.println("s : " + s + " :: t : " + t + " -> " + isSubsequence(s, t));

        s = "b";
        t = "a";
        System.out.println("s : " + s + " :: t : " + t + " -> " + isSubsequence(s, t));

        s = "ab";
        t = "baab";
        System.out.println("s : " + s + " :: t : " + t + " -> " + isSubsequence(s, t));

        s = "leeeeetcode";
        t = "yyyyylyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyytyyyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyycyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyoyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyydyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy...";
        System.out.println("s : " + s + " :: t : " + t + " -> " + isSubsequence(s, t));
    }


    public static void displayEmployee() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(100, "Scarlet", 500000, 34, "F", "Witchcraft", 2008));
        empList.add(new Employee(101, "James", 600000, 35, "M", "Movies", 2008));
        empList.add(new Employee(102, "Steven", 700000, 36, "M", "Movies", 2009));
        empList.add(new Employee(103, "Roger", 800000, 37, "M", "Avengers", 2009));
        empList.add(new Employee(104, "Tony", 900000, 38, "M", "Avengers", 2009));
        empList.add(new Employee(105, "Thor", 1500000, 10000, "M", "Asgard", 2010));
        empList.add(new Employee(106, "Natasha", 2500000, 39, "F", "Avengers", 2018));
        empList.add(new Employee(106, "QuickSilver", 3500000, 36, "M", "Avengers", 2018));


        empList.stream()
                .filter(employee -> employee.getSalary() > 80000)
                .map(Employee::getName)
                .forEach(System.out::println);


        List<Empl> eList = new ArrayList<>();
        Empl empl = new Empl();
        empl.setName("Scarlet");
        empl.setSalary(500000.0);
        empl.setAge(34);
        eList.add(empl);

        empl = new Empl();
        empl.setName("James");
        empl.setSalary(600000.0);
        empl.setAge(35);
        eList.add(empl);

        empl = new Empl();
        empl.setName("Steven");
        empl.setSalary(700000.0);
        empl.setAge(40);
        eList.add(empl);

        empl = new Empl();
        empl.setName("Roger");
        empl.setSalary(800000.0);
        empl.setAge(134);
        eList.add(empl);

        Predicate<Double> salLt800k = x -> x < 800000.0;

        System.out.println("----------------------------");
        eList.stream()
                .filter(employee -> employee.getSalary() > 500000.0)
                .filter(employee -> salLt800k.test(employee.getSalary()))
                .map(Empl::getName)
                .forEach(System.out::println);

        Map<String, List<Employee>> deptMap = empList.stream().collect(groupingBy(e -> e.getDepartment()));
        System.out.println("deptMap : " + deptMap);

        Map<String, Map<Integer, List<Employee>>> deptAndAgeMap = empList.stream().collect(groupingBy(e -> e.getDepartment(), groupingBy(e -> e.getAge())));
        System.out.println("deptAndAgeMap : " + deptAndAgeMap);

        Predicate<String> isMaleEmployee = x -> x.equals("M");
        Map<Boolean, List<Employee>> gndrPartitionEmpList = empList.stream().collect(partitioningBy(e -> isMaleEmployee.test(e.getGender())));
        System.out.println("gndrPartitionEmpList : " + gndrPartitionEmpList);

        Map<Boolean, Map<Integer, List<Employee>>> gndrPartitionGrpByAge =
                empList.stream().collect(partitioningBy(e -> isMaleEmployee.test(e.getGender()), groupingBy(Employee::getAge)));
        System.out.println("gndrPartitionGrpByAge : " + gndrPartitionGrpByAge);

        IntSummaryStatistics iss = empList.stream().collect(Collectors.summarizingInt(Employee::getAge));
        System.out.println("IntSummaryStatistics : " + iss);
        System.out.println("IntSummaryStatistics.getCount() : " + iss.getCount());

    }

    public static boolean isSubsequence(String s, String t) {
        System.out.println("\n\t s : " + s + " :: t : " + t);
        if (s.isBlank()) {
            return true;
        }

        int temp = 0;
        for(char chr : t.toCharArray()){
            if(s.charAt(temp) == chr ){
                temp++;
            }
            if(temp == s.length()){
                return true;
            }
        }

        return false;

//        int prvIdx = -1;
//        boolean result = false;
//        if(t.contains(s)){
//            return true;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            char chr = s.charAt(i);
//            System.out.println("\t chr : " + chr);
//            int currIdx = t.indexOf(chr);
//            System.out.println("\t\t " + chr + " : " + currIdx);
//            if (currIdx > prvIdx) {
//                prvIdx = currIdx;
//                result = true;
//            } else {
//                return false;
//            }
//        }
//        return result;
    }

}

//  @PostMapping( value = "saveData/", @MediaType(producer = Application.JSON , consumes = JSON) )
//      public void saveData(@ResponseBody List<Employee> employee){                        
//
//
//        EmlplService emlplService = new EmplService();
//      List rtnList = emlplService.saveData(employee) //parsing & validation
//
//        return http.rsponse.body(rtnList).header().status(HTTP.success);
//
//  }
//
//}
//
//
//url = /getData?id=123/val=sth
//
//
//








