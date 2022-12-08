package com.example.demo.utils;


import com.example.demo.dto.PogGuide;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * Utility class for CSV related common/utility methods
 */
@Component
public class CsvWriter {

    /**
     * @param csvDataList
     * @param csvPogGuideFileName
     * @return PogGuide
     * @throws IOException
     * @implNote This method creates a csv, saves it to StringWriter and returns as PogGuide object
     */
    public PogGuide generateCSV(List<List<String[]>> csvDataList, String csvPogGuideFileName) throws IOException {
        StringWriter sw = new StringWriter();
        CSVWriter writer = new CSVWriter(sw);
        writer.writeAll(csvDataList.get(0), false);
        writer.close();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.out.println("\t sw.toString().getBytes() : " + sw.toString().getBytes());
        outputStream.write(sw.toString().getBytes());
        System.out.println("\t outputStream : " + outputStream);
        
        return new PogGuide(csvPogGuideFileName, outputStream);
    }
}
