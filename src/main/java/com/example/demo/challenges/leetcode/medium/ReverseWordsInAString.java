package com.example.demo.challenges.leetcode.medium;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.regex.Pattern;

@Slf4j
public class ReverseWordsInAString {
    public static void main(String... args) {

        String input = "the sky is blue";
        String output = "blue is sky the";
        log.info("[{}] reversed successfully : [{}]", input, reverseWords(input));


        input = "  hello world  ";
        output = "world hello";
        log.info("[{}] reversed successfully : [{}]", input, reverseWords(input));

        input = "a good   example";
        output = "example good a";
        log.info("[{}] reversed successfully : [{}]", input, reverseWords(input));


    }

    public static String reverseWords(String s) {

//        log.info("[{}] -> [{}]", s, s.replaceAll("\\s+"," "));
        String[] wordArr = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (int i = wordArr.length - 1; i >= 0; i--) {
            sb.append(wordArr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }


}
