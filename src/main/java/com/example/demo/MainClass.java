package com.example.demo;

//import com.com.example.demo.Producer;

import com.itextpdf.kernel.pdf.colorspace.PdfSpecialCs;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
    public static void main(String... args) {

        String str = "123 door Key17 To Home";
        System.out.println("Door Key  : " + findDoorKey(str));

        str = "23 door Key7 To Home";
        System.out.println("Door Key  : " + findDoorKey(str));

        str = "123 DOOR KEY7 TO HOME";
        System.out.println("Door Key  : " + findDoorKey(str));

        str = "23 door key7 to home";
        System.out.println("Door Key  : " + findDoorKey(str));

    }

    public static String findDoorKey(String str) {

        Pattern regex = Pattern.compile("\\d");
//        String regex = "\\d";
//        Matcher m = Pattern.compile(regex).matcher(str);
//        System.out.println("Digits removed : " + m.replaceAll(""));
//
//        regex = "\\s";
//        System.out.println("Space removed : " + Pattern.compile(regex).matcher(str).replaceAll(""));
//
//        regex = "[A-Z]";
//        System.out.println("UpperCase removed : " + Pattern.compile(regex).matcher(str).replaceAll(""));

        String result = Pattern.compile("\\d").matcher(str).replaceAll("");
//        System.out.println("result - num removed : " + result + " & result.length : " + result.length());

        result = Pattern.compile("\\s").matcher(result).replaceAll("");
//        System.out.println("result - space removed : " + result + " & result.length : " + result.length());

        result = Pattern.compile("[A-Z]").matcher(result).replaceAll("");
//        System.out.println("result - UpperCase removed : " + result + " & result.length : " + result.length());

        StringBuilder sb = new StringBuilder(result);
        result = str.replaceAll("\\D", "");
        System.out.println("result - Numbers in key : " + result);

        if (result.contains("1"))
            sb.append("1");
        else
            sb.append("0");
        sb.append(result);

        return sb.toString();
    }
}
/*
    com.example.demo.Producer producer = new com.example.demo.Producer();
    producer.

@BeforeEach
public void init(){

}

@Test
    public void testConsumer(){

}
}


FileUpload
fileSize -> 2 - 3 GB

1. Check maximum file size that can be uploaded - web / cloud
        0.5GB -> angular-> db
        REST -> media
        BLOB -> lib

        Batch


3 -> 6 partiion

TotalPartion = 6
partition no: 1, 2, 3, 4, 5, 6

        {
            tp:6
            pn: 1
        }
        {
            tp:6
            pn: 2
        }
*/