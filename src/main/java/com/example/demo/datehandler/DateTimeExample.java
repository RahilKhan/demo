package com.example.demo.datehandler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeExample {

	public static void main(String...args) {
		String dateStr = "2015-07-08T00:00:00 ";
		int index = dateStr.indexOf("T");
		dateStr = dateStr.substring(0,index);
		System.out.println("dateStr : " + dateStr);
		
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm");  
        LocalDateTime now = LocalDateTime.now();  
        String pogDate = now.toString();
        System.out.println("DTF - pogDate : " + pogDate);
        
        
    	SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm");
    	Date date = new Date();
    	System.out.println(formatter.format(date));

	}
	
}
