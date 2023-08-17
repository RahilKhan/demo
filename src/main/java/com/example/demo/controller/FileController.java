package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.PogGuide;
import com.example.demo.service.pdfReports.CsvReportGenerator;
import com.example.demo.service.pdfReports.FileService;
import com.example.demo.service.pdfReports.PdfReportGenerator;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileController {
    private final PdfReportGenerator pdfReportGenerator;
    private final CsvReportGenerator csvReportGenerator;
    private final FileService fileService;
    
    @GetMapping(value = "/create-pdf")
    public ResponseEntity<Resource> createPdf(HttpServletRequest request ) throws IOException {
        PogGuide pogGuide = pdfReportGenerator.buildPdf();

        Resource pdfResource = new ByteArrayResource(pogGuide.toByteArray());

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pogGuide.getFileName() + "\"")
                .body(pdfResource);
    }

    @GetMapping(value = "/create-csv")
    public ResponseEntity<Resource> createCsv(HttpServletRequest request ) throws IOException {
        PogGuide pogGuide = csvReportGenerator.buildCsv();



        Resource pdfResource = new ByteArrayResource(pogGuide.toByteArray());

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pogGuide.getFileName() + "\"")
                .body(pdfResource);
    }
    
    @GetMapping(value = "/create-file")
    public ResponseEntity<String> createFile(HttpServletRequest request ) throws IOException {
    	Map<String, ByteArrayOutputStream> fileResponseMap = fileService.buildfileResponse(pdfReportGenerator,csvReportGenerator);

        request.getParameter("id");

    	Gson gsonObj = new Gson();
    	String fileResponseJson = gsonObj.toJson(fileResponseMap);
    	
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("accept", "application/json")
                .body(fileResponseJson);
    }

    @GetMapping(value = "/createZipFile", produces="application/zip")
    public ResponseEntity<ZipOutputStream> createZipFile(HttpServletRequest request ) throws IOException {
    	
    	ZipOutputStream pogGuideZipOutStream = (ZipOutputStream)fileService.buildZipResponse(pdfReportGenerator,csvReportGenerator);

        return ResponseEntity.ok()
        		.contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pogGuideZipOutStream + "\"")
                .body(pogGuideZipOutStream);
    }    
    
    @GetMapping(value = "/ping")
    @ResponseBody
    public String ping() {
        return "Glory to Ukraine!";
    }
}
