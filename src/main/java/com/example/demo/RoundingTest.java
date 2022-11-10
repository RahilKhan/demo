package com.example.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class RoundingTest {

	public static void main(String...args) {
		
		List<Double>  dblList = new ArrayList<>();
		dblList.add(150.0d);
		dblList.add(125.0d);
		dblList.add(166.66666666666669d);
		dblList.add(83.33333333333334);
		dblList.add(55.55555555555556);
		dblList.add(75.0);
		dblList.add(92.3076923076923);
		dblList.add(133.33333333333334);
		
		BigDecimal bd = new BigDecimal(1.555d);
		System.out.println("bd=" + bd);
		bd = bd.setScale(1, RoundingMode.HALF_UP);
		System.out.println("after rounding bd=" + bd);
		double d = bd.doubleValue();
		System.out.println("after rounding d=" + d);
		
		
		System.out.println("\n==================================\n");
		
		dblList.forEach(dbl -> {
			BigDecimal bd1 = new BigDecimal(dbl);
			System.out.println("bd1 = " + bd1);
			bd1 = bd1.setScale(1, RoundingMode.HALF_UP);
			System.out.println("\t after rounding bd1=" + bd1);
			double d1 = bd1.doubleValue();
			System.out.println("\t after rounding d1 = " + d1);
		});
		
		double sls = 3;
		System.out.println("Math.round("+sls+") : " + (int) Math.round(sls));

		sls = 3.0;
		System.out.println("Math.round("+sls+") : " + (int) Math.round(sls));
		
		sls = 3.1;
		System.out.println("Math.round("+sls+") : " + (int) Math.round(sls));

		sls = 3.5;
		System.out.println("Math.round("+sls+") : " + (int) Math.round(sls));

		sls = 3.6;
		System.out.println("Math.round("+sls+") : " + (int) Math.round(sls));

	}
}
