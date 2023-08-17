package com.example.demo.challenges.leetcode.easy;

public class MergeStringAlternately {

    public static void main(String...args) {

        String wd1 = "abc";
        String wd2 = "pqr";
        System.out.println(wd1 + " merged with " + wd2 + " : " + mergeStringAlternately(wd1, wd2));

        wd1 = "abcd";
        wd2 = "pq";
        System.out.println(wd1 + " merged with " + wd2 + " : " + mergeStringAlternately(wd1, wd2));

        wd1 = "ab";
        wd2 = "pqrs";
        System.out.println(wd1 + " merged with " + wd2 + " : " + mergeStringAlternately(wd1, wd2));

        wd1 = "ab";
        wd2 = "rs";
        System.out.println(wd1 + " merged with " + wd2 + " : " + mergeStringAlternately(wd1, wd2));
    }

    public static String mergeStringAlternately(String wd1, String wd2) {

        int len = wd1.length() + wd2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i < wd1.length()) {
                sb.append(wd1.charAt(i));
            }
            if (i < wd2.length()) {
                sb.append(wd2.charAt(i));
            }
        }
        return sb.toString();
    }
}
