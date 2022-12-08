/**
 * 
 */
package com.example.demo.coding;

/**
 * Program for factorial -> F(n) = f(1)*f(2) ....f(n-1)*f(n) 
 * @author Rahil_Khan
 *
 */
public class Factorial {

	/**
	 * Write a program to find the factorial of a given number n using recursion algorithm. a. n is a
	 * non-negative integer. b. Factorial of a non-negative integer n is the
	 * multiplication of all integers smaller than or equal to n
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int factorialResult = factorial(5);
		System.out.println("facorialResult " + factorialResult);
		
		factorialResult = factorial(1);
		System.out.println("factorialResult " + factorialResult);
		
		int factorialResult0 = factorial(0);
		System.out.println("facorialResult0 " + factorialResult0);
		
		int factorialResultNeg1 = factorial(-1);
		System.out.println("facorialResultNeg1 " + factorialResultNeg1);

	}

	private static int factorial(int n) {
		if (n == 1 || n==0)
			return 1;
		else if(n<0)
			throw new IllegalArgumentException("Illegal argument. arg should be greated than or equal to 0");
		
		return n * factorial(n - 1);
	}
}
