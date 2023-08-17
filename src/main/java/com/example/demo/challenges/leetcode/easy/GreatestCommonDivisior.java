package com.example.demo.challenges.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * <p>
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * <p>
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * <p>
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * <p>
 * Example :
 * Input: str1 = "ABCABC", str2 = "ABCABCABCABC"
 * Output: "ABC"
 * <p>
 * Constraints:
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */
@Slf4j
public class GreatestCommonDivisior {

    public static void main(String... args) {

        String str1 = "ABCABC", str2 = "ABC", expected = "ABC";
        log.info("GCD for string {} & {} -> {}; expected -> {}", str1, str2, gcdString(str1, str2), expected);

        str1 = "ABABAB";
        str2 = "ABAB";
        expected = "AB";
        log.info("GCD for string {} & {} -> {}; expected -> {}", str1, str2, gcdString(str1, str2), expected);

        str1 = "ABABABAB";
        str2 = "ABAB";
        expected = "ABAB";
        log.info("GCD for string {} & {} -> {}; expected -> {}", str1, str2, gcdString(str1, str2), expected);

        str1 = "LEET";
        str2 = "CODE";
        expected = "";
        log.info("GCD for string {} & {} -> {}; expected -> {}", str1, str2, gcdString(str1, str2), expected);

        str1 = "ABCABC";
        str2 = "ABCABCABCABC";
        expected = "ABC";
        log.info("GCD for string {} & {} -> {}; expected -> {}", str1, str2, gcdString(str1, str2), expected);

        str1 = "TUCXXTUCXXTUCXX";
        str2 = "TUCXXTUCXX";
        expected = "TUCXX";
        log.info("GCD for string {} & {} -> {}; expected -> {}", str1, str2, gcdString(str1, str2), expected);

        str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        expected = "TAUXX";
        log.info("GCD for string {} & {} -> {}; expected -> {}", str1, str2, gcdString(str1, str2), expected);

    }

    /**
     * Best solution
     */
    public static String gcdString(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdString(str2, str1);
        } else if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.isEmpty()) {
            return str1;
        } else {
            return gcdString(str1.substring(str2.length()), str2);
        }
    }

}
