package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Employee {

	private int id;
	private String name;
	private double salary;
	private int age;
	private String gender;
	private String department;
	private int yearOfJoining;

}
