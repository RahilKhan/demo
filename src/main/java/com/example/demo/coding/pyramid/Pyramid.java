/**
 * 
 */
package com.example.demo.coding.pyramid;

/**
 * @author Rahil_Khan
 *
 */
public class Pyramid {

	/**
	 * https://www.digitalocean.com/community/tutorials/pyramid-pattern-programs-in-java
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		numberIsoscelesPyramid(10);
		astericIsoscelesPyramid(10);


	}

	private static void numberIsoscelesPyramid(int n) {
		System.out.println("\n-----------Number Isosceles Pyramid---------------- ");

		for (int i = 0; i < n; i++) {

			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}

	private static void astericIsoscelesPyramid(int n) {
		System.out.println("\n-----------* Isosceles Pyramid---------------- ");
		for (int i = 0; i < n; i++) {

			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}



}
