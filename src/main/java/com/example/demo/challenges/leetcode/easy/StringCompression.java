package com.example.demo.challenges.leetcode.easy;

public class StringCompression {
    public static void main(String... args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(String.valueOf(chars)+ " -> result : " + compress(chars));

        chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(String.valueOf(chars)+ " -> result : " + compress(chars));

        chars = new char[]{'a'};
        System.out.println(String.valueOf(chars)+ " -> result : " + compress(chars));
    }

    public static int compress(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            System.out.println("\tres : " + res);
            chars[res++] = chars[i];
            System.out.println("\tchars["+i+"] : " + chars[i]);
            System.out.println("\tchars : " + String.valueOf(chars));
            System.out.println("\tres : " + res);
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                    System.out.println("\t\tchars : " + String.valueOf(chars));
                    System.out.println("\t\tres : " + res);
                }
            }
            i += groupLength;
        }
        System.out.println("\tchars : " + String.valueOf(chars));
        return res;
    }
}
