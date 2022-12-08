package com.example.demo.coding;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Rahil_Khan
 *
 */
public class CodingExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] array = {1, 2, 3, -1, -2, 4};
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));

		reverseLinkList();
	}
	
	private static void  reverseLinkList() {
		LinkedList<Integer> ll = new LinkedList<>();

		ll.add(1);
		ll.add(2);
		ll.add(3);

		System.out.println(ll);
		LinkedList<Integer> ll1 = new LinkedList<>();

		ll.descendingIterator().forEachRemaining(ll1::add);
		System.out.println(ll1);

	}

}
