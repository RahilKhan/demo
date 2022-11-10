package com.example.demo.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FixtureAssembly {
	
	@CsvBindByName(column = "ID", required = true)
	private String id;
	
	@CsvBindByName(column = "Name", required = true)
	private String name;
	
	@CsvBindByName(column = "Qty")
	private String qty;

	@CsvBindByName(column = "French")
	private String french;
	
	@CsvBindByName(column = "Comment")
	private String comment;
}
