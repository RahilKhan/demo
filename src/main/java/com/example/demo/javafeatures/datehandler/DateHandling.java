package com.example.demo.datehandler;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

public class DateHandling {

	public static void main(String... args) {

		Date date = new Date();
		String dateStr = date.getTime() + "";
		System.out.println("\n---------------->date : " + date.toString());
		System.out.println("---------------->date : " + date.getTime());
		System.out.println("---------------->dateStr : " + dateStr);

		Calendar calender = Calendar.getInstance();
		calender.setTime(new Date()); // Now use today date.
		calender.add(Calendar.DATE, 10); // Adds 15 days
		
		System.out.println("\n---------------->calender.getTimeInMillis : " + calender.getTimeInMillis());
		System.out.println("---------------->calender.getTime : " + calender.getTime());
		System.out.println("---------------->calender.getTime.getInstance() : " + calender.getInstance());
		
		calender.add(Calendar.DATE, 5); // Adds 15 days
		System.out.println("\n---------------->calender.getTimeInMillis : " + calender.getTimeInMillis());
		System.out.println("---------------->calender.getTime : " + calender.getTime());
		System.out.println("---------------->calender.getTime.getInstance() : " + calender.getInstance());

		calender.add(Calendar.DATE, -25); // Adds 15 days
		System.out.println("\n---------------->past : calender.getTimeInMillis : " + calender.getTimeInMillis());
		System.out.println("---------------->past : calender.getTime : " + calender.getTime());

		calender.add(Calendar.DATE, -10); // Adds 15 days
		System.out.println("\n---------------->past : calender.getTimeInMillis : " + calender.getTimeInMillis());
		System.out.println("---------------->past : calender.getTime : " + calender.getTime());
		
		LocalDateTime  currentDateTime = LocalDateTime
                .ofEpochSecond(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC), 0, ZoneOffset.UTC);
		System.out.println("\n---------------->currentDateTime : " + currentDateTime);
		
		currentDateTime.minusDays(10);
		System.out.println("\n---------------->currentDateTime.minusDays(10) : " + currentDateTime);
		
		currentDateTime = LocalDateTime
                .ofEpochSecond(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC), 0, ZoneOffset.UTC).minusDays(10);
		System.out.println("\n---------------->currentDateTime(-10) : " + currentDateTime);
		

		System.out.println("\n---------------->LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) : " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

		Long currentLongTime = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
		LocalDateTime currentDateTimeNow = LocalDateTime.ofEpochSecond(currentLongTime, 0, ZoneOffset.UTC);
		Long currentDateTimeNowMillis = currentDateTimeNow.toEpochSecond(ZoneOffset.UTC);
		LocalDateTime currentDateTimeBack = LocalDateTime.ofEpochSecond(currentDateTimeNowMillis, 0, ZoneOffset.UTC);
	    System.out.println("\n\t currentLongTime          : " + currentLongTime
	    		         + "\n\t currentDateTimeNow       : " + currentDateTimeNow 
	    		         + "\n\t currentDateTimeNowMillis : " + currentDateTimeNowMillis 
	    		         + "\n\t currentDateTimeBack      : " + currentDateTimeBack );
	    
	    	    
		currentLongTime = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
		LocalDateTime pastExpireOnDateTime = LocalDateTime.ofEpochSecond(currentLongTime, 0, ZoneOffset.UTC).minusDays(5);
		Long pastExpireOnDateTimeMillis = pastExpireOnDateTime.toEpochSecond(ZoneOffset.UTC);
		LocalDateTime pastDateTimeBack = LocalDateTime.ofEpochSecond(pastExpireOnDateTimeMillis, 0, ZoneOffset.UTC);

		LocalDateTime pastNotBeforeDateTime = LocalDateTime.ofEpochSecond(currentLongTime, 0, ZoneOffset.UTC).minusDays(10);
		Long pastNotBeforeDateTimeMillis = pastNotBeforeDateTime.toEpochSecond(ZoneOffset.UTC);

	    System.out.println("\n\t currentLongTime             : " + currentLongTime
	    		         + "\n\t pastExpireOnDateTime        : " + pastExpireOnDateTime 
	    		         + "\n\t pastExpireOnDateTimeMillis  : " + pastExpireOnDateTimeMillis 
	    		         + "\n\t pastNotBeforeDateTime       : " + pastNotBeforeDateTime 
	    		         + "\n\t pastNotBeforeDateTimeMillis : " + pastNotBeforeDateTimeMillis	    		         
	    		         + "\n\t pastDateTimeBack            : " + pastDateTimeBack 
	    		         + "\n\t pastExpireOnDateTimeMillis.toString()  : " + pastExpireOnDateTimeMillis.toString() 
	    		         + "\n\t pastNotBeforeDateTimeMillis.toString() : " + pastNotBeforeDateTimeMillis.toString()	    	         
	    		);	    
	    
	    

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
}
