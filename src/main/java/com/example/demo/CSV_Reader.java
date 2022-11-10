package com.example.demo;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.FixtureAssembly;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSV_Reader {

	public static void main(String... args) throws IOException {
		String filePath = "C:\\Users\\Rahil_Khan\\Downloads\\csv\\country.csv";
		String fixturePath = "C:\\Users\\Rahil_Khan\\Downloads\\csv\\fixture.csv";

		List<String[]> collect = Files.lines(Paths.get(filePath)).map(line -> line.split(","))
				.collect(Collectors.toList());
		System.out.println("collect : " + collect.toString());

		collect.forEach(line -> {
			System.out.println(line);
			for (String item : line) {
				System.out.println("\t item : " + item);
			}
		});

		List<String[]> fixtureCollect = Files.lines(Paths.get(fixturePath)).map(line -> line.split(",", -1))
				.collect(Collectors.toList());
		System.out.println("fixtureCollect : " + fixtureCollect.toString());

		fixtureCollect.forEach(line -> {
			System.out.println("fixtureSummary csv array : ");
			for (String item : line) {
				System.out.println("\t item : " + item);
			}
		});

		
		System.out.println("\n------------------------- OpenCSV -------------------------");
		
		String fixtureSummaryStr = "ID,Qty,Name,French,Comment\r\n"
				+ "0953366,12,\"LD SHELF PNL 24X46\"\" \",TRAVERSE 24X46 PO,\r\n"
				+ "0953367,24,\"LD RTL SDMNT BM46X2\"\"\",,\r\n"
				+ "0954792,39,\"DIVDR,F/S 1X24\"\"ANWHT\",SEPAR.IND.1X24 BC A.,\r\n"
				+ "0958524,14,\"BP. SHELF CHANL.48\"\" \",,";

		List<FixtureAssembly> fixtureSummaryBeanList = new CsvToBeanBuilder<FixtureAssembly>(new StringReader(fixtureSummaryStr))
				.withType(FixtureAssembly.class).build().parse();
		System.out.println("\t fixtureSummaryBeanList : " + fixtureSummaryBeanList.toString());
		
        List<FixtureAssembly> sortedList = fixtureSummaryBeanList.stream()
                .sorted(Comparator.comparing(FixtureAssembly::getId).reversed())
                .collect(Collectors.toList());
        
		System.out.println("\n\t sortedList : " + sortedList.toString());
	}

}
