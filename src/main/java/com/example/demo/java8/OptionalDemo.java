package com.example.demo.java8;

import java.util.Optional;

/**
 * @author Rahil_Khan
 *
 */
public class OptionalDemo {
	public static void main(String[] args) {
		String[] words = new String[10];
		Optional<String> checkNull = Optional.ofNullable(words[5]);

		/*
		 * Below statment throws exception java.util.NoSuchElementException: No value
		 * present As checkNull is empty
		 * 
		 * System.out.print(checkNull.get());
		 */

		/* Correct way to handle Optional value */
		if (checkNull.isPresent()) {
			String word = words[5].toLowerCase();
			System.out.print(word);
		} else
			System.out.println("word is null");

		System.out.println("danno : " + changeCase("danno"));
		System.out.println("null  : " + changeCase(null));
	}

	static Optional<String> changeCase(String word) {

//		Optional<String> nameChk = Optional.ofNullable(word);
//		return nameChk.isPresent() ? Optional.of(word.toUpperCase()) : Optional.ofNullable(word);
		return Optional.ofNullable(word).isPresent() ? Optional.of(word.toUpperCase()) : Optional.ofNullable(word);

	}

}
