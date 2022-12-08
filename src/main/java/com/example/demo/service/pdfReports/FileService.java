package com.example.demo.service.pdfReports;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.cantire.tetris.log.TetrisLogger;

import com.example.demo.dto.PogGuide;
import com.example.demo.exception.FileGenerationException;
import com.example.demo.utils.Constants;

import lombok.RequiredArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Rahil_Khan
 *
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileService {

	public Map<String, ByteArrayOutputStream> buildfileResponse(PdfReportGenerator pdfReportGenerator, CsvReportGenerator csvReportGenerator) throws IOException {
		PogGuide pdfPogGuide = pdfReportGenerator.buildPdf();
		PogGuide csvPogGuide = csvReportGenerator.buildCsv();

		Map<String, ByteArrayOutputStream> fileResponseMap = new HashMap<>();
		fileResponseMap.put("pdf", pdfPogGuide.getByteArrayOutputStream());
		fileResponseMap.put("csv", csvPogGuide.getByteArrayOutputStream());
		
		return fileResponseMap;
	}

	public Object buildZipResponse(PdfReportGenerator pdfReportGenerator, CsvReportGenerator csvReportGenerator) throws IOException {
		PogGuide pdfPogGuide = pdfReportGenerator.buildPdf();
		PogGuide csvPogGuide = csvReportGenerator.buildCsv();

//		Resource pdfResource = new ByteArrayResource(pdfPogGuide.toByteArray());
//		Resource csvResource = new ByteArrayResource(csvPogGuide.toByteArray());
		
		List<PogGuide> pogGuideList = Arrays.asList(csvPogGuide, pdfPogGuide);
		return createZipFile(pogGuideList);
		
	}	
	
	private ZipOutputStream createZipFile(List<PogGuide> pogGuideList) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(Constants.POG_GUIDE_ZIP_FILE);
		} catch (FileNotFoundException fnfe) {
			TetrisLogger.error("TetrisService.tetrisFilebuilder() - Exception occured while creating zip file -> "
					+ fnfe.getMessage());
			fnfe.printStackTrace();
			throw new FileGenerationException(fnfe);
		}
		ZipOutputStream zipOutStream = new ZipOutputStream(fos);
		try {
			for (PogGuide pogGuide : pogGuideList) {
				Resource resource = new ByteArrayResource(pogGuide.toByteArray());
				File fileToZip = new File(pogGuide.getFileName());
				FileInputStream fis = new FileInputStream(fileToZip);
				ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
				zipOutStream.putNextEntry(zipEntry);

				byte[] bytes = new byte[1024];
				int length;
				while ((length = fis.read(pogGuide.toByteArray())) >= 0) {
					zipOutStream.write(bytes, 0, length);
				}
				fis.close();
			}
			zipOutStream.close();
			fos.close();
		} catch (IOException ioe) {
			TetrisLogger.error("TetrisService.tetrisFilebuilder() - Exception occured while creating zip file -> "
					+ ioe.getMessage());
			ioe.printStackTrace();
			throw new FileGenerationException(ioe);
		}

		return zipOutStream;
	}
}
