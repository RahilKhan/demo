package com.example.demo.datehandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeExample {

	public static void main(String... args) {
		String dateStr = "2015-07-08T00:00:00 ";
		int index = dateStr.indexOf("T");
		dateStr = dateStr.substring(0, index);
		System.out.println("dateStr : " + dateStr);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm");
		LocalDateTime now = LocalDateTime.now();
		String pogDate = now.toString();
		System.out.println("DTF - pogDate : " + pogDate);

		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		Date date = new Date();
		System.out.println(formatter.format(date));

		String startDate = "10-01-2018 01:10:20";
		String endDate = "10-06-2020 06:30:50";

		findDifference(startDate, endDate);
	}

	private static void findDifference(String startDate, String endDate) {
		/* SimpleDateFormat converts the string format to date object */

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		try {
			/* Parse method is used to parse the text from a string to produce the date */
			Date d1 = sdf.parse(startDate);
			Date d2 = sdf.parse(endDate);
			/* Calculate time difference in milliseconds */
			long difference_In_Time = d2.getTime() - d1.getTime();

			/* Calculate time difference in seconds, minutes, hours, years, and days */
			long difference_In_Seconds = (difference_In_Time / 1000) % 60;

			long difference_In_Minutes = ((difference_In_Time / (1000 * 60)) % 60) % 60;

			long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;

			long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));

			long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

			/*
			 * Print the date difference in years, in days, in hours, in minutes, and in
			 * seconds
			 */
			System.out.println("Difference between two dates is: : " + startDate + " & " + endDate);
			System.out.println(
					"difference_In_Time : "  + difference_In_Time + "\n" +
					difference_In_Years + " years, " + difference_In_Days + " days, " + difference_In_Hours
					+ " hours, " + difference_In_Minutes + " minutes, " + difference_In_Seconds + " seconds");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
