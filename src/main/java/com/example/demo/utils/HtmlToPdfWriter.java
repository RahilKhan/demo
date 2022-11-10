package com.example.demo.utils;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Component
public class HtmlToPdfWriter {

    private void mergeHtmlPage(PdfMerger merger, String htmlPage) throws IOException {
        try (ByteArrayOutputStream pageOS = new ByteArrayOutputStream()) {
            ConverterProperties properties = new ConverterProperties();
            properties.setFontProvider(new DefaultFontProvider(true, true, true));
            HtmlConverter.convertToPdf(htmlPage, pageOS, properties);

            try (PdfDocument pogSubpage = new PdfDocument(new PdfReader(new ByteArrayInputStream(pageOS.toByteArray())))) {
                merger.merge(pogSubpage, 1, pogSubpage.getNumberOfPages());
            }
        }
    }

    public void write(OutputStream outputStream, List<String> htmlPages) throws IOException {
        PdfDocument resultDocument = new PdfDocument(new PdfWriter(outputStream));
        PdfMerger merger = new PdfMerger(resultDocument);

        for (String htmlPage : htmlPages) {
            mergeHtmlPage(merger, htmlPage);
        }

        resultDocument.close();
    }
    
    public void write(String pdfDestination, List<String> htmlPages) throws IOException {
        PdfDocument resultDocument = new PdfDocument(new PdfWriter(pdfDestination));
        PdfMerger merger = new PdfMerger(resultDocument);

        for (String htmlPage : htmlPages) {
            mergeHtmlPage(merger, htmlPage);
        }

        resultDocument.close();
    }
}
