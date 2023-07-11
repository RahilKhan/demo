package com.example.demo.misc;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MiscFunctionality {

    public static void main(String[] args) {
        String text = "";
        int lineCharLimit = 10;
        double result = getTextLinesCount(text, lineCharLimit);
        System.out.println("result : " + result);


    }


    public static double getTextLinesCount(String text, int lineCharLimit) {
        String[] textLines = text.split("\n");
        return Arrays.stream(textLines)
                .map(line -> Math.ceil((double) line.length() / Math.max(lineCharLimit, 1)))
                .reduce(0.0, Double::sum);
    }

}
