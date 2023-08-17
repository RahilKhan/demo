package com.example.demo.coding.interviewcodes.studentManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void printAllStudents() {
//        for (Student student : students) {
//            System.out.println(student);
//        }
        students.stream().forEach(System.out::println);
    }

    public void printStudentsByGrade(String grade) {
//        for (Student student : students) {
//            if (student.getGrade().equals(grade)) {
//                System.out.println(student);
//            }
//        }

        students.stream().filter(student -> student.getGrade().equals(grade)).forEach(System.out::println);

    }

    public double calculateAverageScore() {
        double sum = 0.0;
        int count = 0;
        for (Student student : students) {
            sum += student.getScore();
            count++;
        }
        /* Apply null check; return default value in case sum and count == 0
         * Arithmetic exception handling in case sum = 0 and count > 0
         */
        return sum / count;
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.addStudent(new Student("John", "A", 85.5));
        system.addStudent(new Student("Alice", "B", 75.0));
        system.addStudent(new Student("Bob", "A", 92.3));

        System.out.println("All Students:");
        system.printAllStudents();

        System.out.println("Students in Grade A:");
        system.printStudentsByGrade("A");

        System.out.println("Average Score: " + system.calculateAverageScore());
    }
}



