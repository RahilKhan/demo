package com.example.demo.regex;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.utils.Constants;

public class RegularExpressionHandler {

	public static void main(String...args) {
		RegularExpressionHandler regExpHandler = new RegularExpressionHandler();
		regExpHandler.nameDateSplit();
	}
	
	public void nameDateSplit() {
		Pattern datePtrn = Pattern.compile(Constants.REGEX_DATE_FORMAT_WD_HYPEN_YYYY_MM_DD);
		Matcher matchedGrp = datePtrn.matcher(Constants.NAME_MULTI_HYPEN_DATE);
		System.out.println("Pattern found : " + matchedGrp);

	    if (matchedGrp.find()) {
	        System.out.println("matchedGrp.group(0) : " + matchedGrp.group(0)); // whole matched expression
//	        System.out.println(m.group(1)); // first expression from round brackets (Testing)
//	        System.out.println(m.group(2)); // second one (123)
//	        System.out.println(m.group(3)); // third one (Testing)
	    }
        
	    matchedGrp = datePtrn.matcher(Constants.NAME_SINGLE_HYPEN_DATE);
		if(matchedGrp.find()) {
			System.out.println("matchedGrp.group(0) : " + matchedGrp.group(0)); // whole matched expression
		}
	    
	    
		String[] nameDateSplit = datePtrn.split(Constants.NAME_MULTI_HYPEN_DATE);
		System.out.println("nameDateSplit : " + nameDateSplit.length);
		System.out.println("nameDateSplit[0] : " + nameDateSplit[0]);
//		System.out.println("nameDateSplit : " + nameDateSplit[1]);
		
		String quoteDateStr = datePtrn.quote(Constants.NAME_MULTI_HYPEN_DATE);
		System.out.println("quoteDateStr : " + quoteDateStr);
		
	}
	
}
