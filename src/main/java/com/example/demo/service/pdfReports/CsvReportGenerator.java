package com.example.demo.service.pdfReports;

import com.example.demo.dto.PogGuide;
import com.example.demo.utils.Constants;
import com.example.demo.utils.CsvWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CsvPogGuideBuilder provide service related to CSV file generation
 *
 * @author Rahil_Khan
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CsvReportGenerator {

	private CsvWriter csvWriter;
//	private String csvPogGuideFileName = "POG Setup Guide.csv";
	/*
	public CsvReportGenerator(CsvWriter csvWrtr) {
		this.csvWriter = csvWrtr;
	}
	
	public static void main(String... args) {
		CsvWriter csvWrtr = new CsvWriter();
		CsvReportGenerator csvReportGenerator = new CsvReportGenerator(csvWrtr);
		try {
			PogGuide pogGuide = csvReportGenerator.buildCsv();
			log.debug("CSV pogGuide : " + pogGuide.toString());
			log.debug("CSV pogGuide.getByteArrayOutputStream : " + pogGuide.getByteArrayOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	public PogGuide buildCsv() throws IOException {
		csvWriter = new CsvWriter();
		List<String[]> data = new ArrayList<>();
		String[] csvDataArray = new String[] {
				"Product Number", "Segment", "Facings", "Bin Capacity", "Label Type","Q1F", "# of Labels", 
				"0370245","1","1","17","O","17.0","1",
				"0370248","1","1","9","O","9.0","1",
				"0370249","1","1","9","O","9.0","1",
				"0370593","1","2","28","O","14.0","2",
				"0370749","1","1","13","O","13.0","1",
				"0372005","1","1","19","O","19.0","1",
				"0372288","1","4","36","D","9.0","4",
				"0372503","1","1","14","O","14.0","1",
				"0372511","1","1","18","O","18.0","1",
				"0372542","1","4","76","O","19.0","4",
				"0372548","1","1","16","O","16.0","1",
				"0372549","1","1","15","O","15.0","1"
		}; 
		data.add(csvDataArray);

		List<List<String[]>> csvDataList = new ArrayList<>();
		csvDataList.add(data);
		return csvWriter.generateCSV(csvDataList, Constants.POG_GUIDE_CSV_FILE);
	}


}
