/**
 * 
 */
package com.example.demo.coding.pyramid;

/**
 * @author Rahil_Khan
 *
 */
public class RtAnglePyramid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		rtAnglePyramidLeft(10);
		rtAnglePyramidRight(10);
		rtAnglePyramidInvertedLeft(10);
		rtAnglePyramidInvertedRight(10);
	}

	private static void rtAnglePyramidLeft(int n) {
		System.out.println("\n-----------Rignt Angle triangle Left---------------- ");
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	private static void rtAnglePyramidRight(int n) {
		System.out.println("\n-----------Rignt Angle triangle Right---------------- ");
		for (int i = 0; i < n; i++) {

			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	private static void rtAnglePyramidInvertedLeft(int n) {
		System.out.println("\n-----------Rignt Angle triangle Inverted Left---------------- ");
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

	private static void rtAnglePyramidInvertedRight(int n) {
		System.out.println("\n-----------Rignt Angle triangle Right-WIP---------------- ");
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= n - i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

}
