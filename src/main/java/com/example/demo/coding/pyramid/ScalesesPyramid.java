/**
 * 
 */
package com.example.demo.coding.pyramid;

/**
 * @author Rahil_Khan
 *
 */
public class ScalesesPyramid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		scalesePyramidRight(10);
		scalesePyramidInvertedRight(10);
		scalesePyramidInvertedLeft(10);
		scalesePyramidLeft(10);

	}

	private static void scalesePyramidRight(int n) {
		System.out.println("\n-----------Scalese triangle Right---------------- ");
		for (int i = n; i >= 0; i--) {
			System.out.println("");
			for (int j = i; j <= n - 1; j++) {
				System.out.print(" ");
			}
			for (int j = n - 1; j >= i; j--) {
				System.out.print("*");
			}
		}

	}

	private static void scalesePyramidInvertedRight(int n) {
		System.out.println("\n-----------Scalese triangle Inverted Right---------------- ");
		for (int i = 0; i < n; i++) {
			for (int j = i; j <= n - 1; j++) {
				System.out.print(" ");
			}
			for (int j = n - 1; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

	private static void scalesePyramidLeft(int n) {
		System.out.println("\n-----------Scalese triangle Left---------------- ");
		for (int i = n ; i >= 1; i--) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}
			for (int j = i; j >= 1; j--) {
				System.out.print("*");				
			}
			System.out.println("");
		}
	}

	private static void scalesePyramidInvertedLeft(int n) {
		System.out.println("\n-----------Scalese triangle Inverted Left---------------- ");
		for (int i = n ; i >= 0; i--) {
			System.out.println("");
			for (int j = i; j >= 1; j--) {
				System.out.print("  ");				
			}
			for (int j = 1; j <= n - i; j++) {
				System.out.print("*");
			}
		}

	}
	
}
