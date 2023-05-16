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
		numberIsoscelesPyramid(9);
		numberInvertedIsoscelesPyramid(9);
		astericIsoscelesPyramid(9);
		astericInvertedIsoscelesPyramid(9);
	}

	private static void numberIsoscelesPyramid(int n) {
		System.out.println("\n-----------Number Isosceles Pyramid---------------- ");

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}

	private static void numberInvertedIsoscelesPyramid(int n) {
		System.out.println("\n-----------Number Inverted Isosceles Pyramid---------------- ");

		for (int i = n, k = 1; i >= 1; i--, k++) {

			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
//			for (int j = i; j >= 1; j--) {
//				System.out.print(i + " ");
//			}
			for (int j = 1; j <= i; j++) {
				System.out.print(k + " ");
			}
			System.out.println("");
		}
	}

	private static void astericIsoscelesPyramid(int n) {
		System.out.println("\n-----------* Isosceles Pyramid---------------- ");
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

	private static void astericInvertedIsoscelesPyramid(int n) {
		System.out.println("\n-----------* Isosceles Pyramid---------------- ");
		for (int i = n; i >= 1; i--) {

			for (int j = 1; j <= n - i; j++) {
				System.out.print("-");
			}
			for (int j = i; j >= 1; j--) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

}
