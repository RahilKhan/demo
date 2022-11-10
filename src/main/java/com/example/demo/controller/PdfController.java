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
import com.example.demo.service.pdfReports.PdfReportGenerator;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PdfController {
    private final PdfReportGenerator pdfReportGenerator;

    @GetMapping(value = "/create-pdf")
    public ResponseEntity<Resource> createPdf(HttpServletRequest request ) throws IOException {
        PogGuide pogGuide = pdfReportGenerator.buildPdf();

        Resource pdfResource = new ByteArrayResource(pogGuide.toByteArray());

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pogGuide.getFileName() + "\"")
                .body(pdfResource);
    }

    @GetMapping(value = "/ping")
    @ResponseBody
    public String ping() {
        return "Glory to Ukraine!";
    }
}
