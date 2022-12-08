/**
 * 
 */
package com.example.demo.coding.hkrrank;

import java.util.Scanner;

/**
 * @author Rahil_Khan
 *
 */
public class ScannerEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter input int, double & string");
		int inputInt = myObj.nextInt();
		double inputDouble = myObj.nextDouble();
		myObj.next();
		String inputStr = myObj.nextLine();
		myObj.close();

		System.out.println(inputStr);
		System.out.println(inputDouble);
		System.out.println(inputInt);
	}

}
