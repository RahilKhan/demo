package com.example.demo.service.pdfReports;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Options;
import com.example.demo.dto.PogGuide;
import com.example.demo.model.dummy.DummyReportModel;
import com.example.demo.model.ReportModel;
import com.example.demo.template.SavingThymeleafTemplateProcessor;
import com.example.demo.template.TemplateProcessor;
import com.example.demo.utils.Constants;
import com.example.demo.utils.HtmlToPdfWriter;

import lombok.RequiredArgsConstructor;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PdfReportGenerator {

	private TemplateProcessor templateProcessor;
	private HtmlToPdfWriter htmlToPdfWriter;
	private String pogGuideFileName = Constants.POG_GUIDE_PDF_FILE;
	private String pogPerfHtmlFile = "PerformanceReport.html";
	private String pogExclHtmlFile = "ExcludedReport.html";
	private String pogFixSummaryHtmlFile = "FixtureSummaryReport.html";
	private String pdfDestination = "C:\\Users\\Rahil_Khan\\Downloads\\tetris-testing\\samplePdf"; // "C:\\tetris"; //

	public static void main(String... args) {
		PdfReportGenerator pdfReportGenerator = new PdfReportGenerator();
		try {
			pdfReportGenerator.buildPdf();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PogGuide buildPdf() throws IOException {
		System.out.println("PdfReportGenerator : buildPdf");

		boolean dirStatus = checkAndCreateDirectory(pdfDestination);
		PogGuide pogGuide = null;
		if (dirStatus) {
//			templateProcessor = new ThymeleafTemplateProcessor();
			templateProcessor = new SavingThymeleafTemplateProcessor();
			htmlToPdfWriter = new HtmlToPdfWriter();

			List<String> htmlPages = new ArrayList<>();

			String prodPerfFileName = pdfDestination + "\\" + pogPerfHtmlFile;
			List<ReportModel> includeReportModels = DummyReportModel.getReportModelList(Options.PERFORMANCE);
			List<String> includeReportHtml = includeReportModels.stream()
					.map(model -> templateProcessor.process(model, "productPerformanceReport"))
					.collect(Collectors.toList());
			htmlPages.addAll(includeReportHtml);
			boolean includeReportHtmlStatus = createHtmlFile(includeReportHtml.toString(), prodPerfFileName);
			log.debug("includeReportHtml - includeReportHtmlStatus : " + includeReportHtmlStatus);

			String prodExclFileName = pdfDestination + "\\" + pogExclHtmlFile;
			List<ReportModel> excludeReportModels = DummyReportModel.getReportModelList(Options.EXCLUDE);
			log.debug("excludeReportModels : " + excludeReportModels.toString());
			List<String> excludeReportHtml = excludeReportModels.stream()
					.map(model -> templateProcessor.process(model, "productExcludeReport"))
					.collect(Collectors.toList());
			htmlPages.addAll(excludeReportHtml);
			boolean excludeReportHtmlStatus = createHtmlFile(excludeReportHtml.toString(), prodExclFileName);
			log.debug("excludeReportModels - excludeReportHtmlStatus : " + excludeReportHtmlStatus);

			String pogFixSummaryFile = pdfDestination + "\\" + pogFixSummaryHtmlFile;
			List<ReportModel> fixtureSummaryListModel = DummyReportModel.getReportModelList(Options.FIXTURE_SUMMARY);
	        List<String> fixtureSummaryHtml = fixtureSummaryListModel.stream()
	                .map(model -> templateProcessor.process(model, "fixtureSummaryList"))
	                .collect(Collectors.toList());
	        htmlPages.addAll(fixtureSummaryHtml);
			boolean fixtureSummaryHtmlStatus = createHtmlFile(fixtureSummaryHtml.toString(), pogFixSummaryFile);
			log.debug("fixtureSummaryListModel - fixtureSummaryHtmlStatus : " + fixtureSummaryHtmlStatus);
			
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			htmlToPdfWriter.write(outputStream, htmlPages);
//			htmlToPdfWriter.write(pdfDestination, htmlPages);

			pogGuide = new PogGuide(pogGuideFileName, outputStream);
//	        log.debug("PdfReportGenerator : build - pogGuide - " + pogGuide);

		}

		return pogGuide;
	}

	/**
	 * This method created html file for the input html content Read more:
	 * https://www.java67.com/2014/02/how-to-create-file-and-directory-in-java.html#ixzz7aynPIkmz
	 * 
	 * @param excludeReportHtmls
	 * @return boolean status
	 * @throws IOException
	 */
	private boolean createHtmlFile(String fileContent, String fileName) throws IOException {
		boolean success = false;

		File file = new File(fileName);
		if (file.exists()) {
			System.out.println("File already exists");
			success = true;
		} else {
			System.out.println("No such file exists, creating now");
			success = file.createNewFile();
			if (success) {
				System.out.printf("Successfully created new file: %s%n", file);
			} else {
				System.out.printf("Failed to create new file: %s%n", file);
			}
		}

		success = writeToFile(fileName, fileContent);
		return success;
	}

	/**
	 * Write File content to a file
	 * 
	 * @param fileName
	 * @param fileContent
	 * @return
	 */
	public boolean writeToFile(String fileName, String fileContent) {
		boolean success = false;
		try {
			FileWriter myWriter = new FileWriter(fileName);
			myWriter.write(fileContent);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
			success = true;
		} catch (IOException e) {
			System.out.println("An error occurred.");
			success = false;
			e.printStackTrace();

		}

		return success;
	}

	/**
	 * Check and create dir if it does not exist. Read more:
	 * https://www.java67.com/2014/02/how-to-create-file-and-directory-in-java.html#ixzz7ayjYCWr3
	 * 
	 * @return boolear
	 */
	public boolean checkAndCreateDirectory(String dir) {
		boolean success = false;
		File directory = new File(dir);

		if (directory.exists()) {
			log.debug("Directory already exists ...");
			success = true;
		} else {
			log.debug("Directory not exists, creating now");
			success = directory.mkdir();
			if (success) {
				log.debug("Successfully created new directory : %s%n", dir);
			} else {
				log.debug("Failed to create new directory: %s%n", dir);
			}
		}

		return success;
	}
}
