package com.example.demo.challenges.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.Stack;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * <p>
 * Example 1:
 * Input: s = "hello"
 * Output: "holle"
 * <p>
 * Example 2:
 * Input: s = "leetcode"
 * Output: "leotcede"
 * <p>
 * Constraints:
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
@Slf4j
public class ReverseVowelsOfAString {

    public static void main(String... args) {
        String str = "hello";
        log.info("{} -> {} ", str, reverseVowels(str));

        str = "leetcode";
        log.info("{} -> {} ", str, reverseVowels(str));

        str = "aA";
        log.info("{} -> {} ", str, reverseVowels(str));

        str = "a.";
        log.info("{} -> {} ", str, reverseVowels(str));

    }

    public static String reverseVowels(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        char[] chrArr = s.toCharArray();

        while (lo < hi) {
            if (!isVowel(s.charAt(lo))) {
                lo++;
                continue;
            }
            if (!isVowel(s.charAt(hi))) {
                hi--;
                continue;
            }

            char temp = s.charAt(lo);
            chrArr[lo] = chrArr[hi];
            chrArr[hi] = temp;

            lo++;
            hi--;
        }
        return String.valueOf(chrArr);
    }

    public static String reverseVowels1(String s) {

        char[] charArray = s.toCharArray();
        int chrArrLen = charArray.length;

        for (int i = 0; i < chrArrLen; i++) {
            char leftVowel = '\0';
            char rightVowel = '\0';

            if (isVowel(charArray[i]))
                leftVowel = charArray[i];
            else
                continue;
            for (int j = chrArrLen - 1; j >= 0; j--) {
                if (isVowel(charArray[j]))
                    rightVowel = charArray[j];


                if (leftVowel != '\0' && rightVowel != '\0') {
                    charArray[i] = rightVowel;
                    charArray[j] = leftVowel;
                    chrArrLen = j;
                    break;
                }
            }
        }

        return String.valueOf(charArray);
    }

    public static boolean isVowel(char chr) {
        return chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u' ||
                chr == 'A' || chr == 'E' || chr == 'I' || chr == 'O' || chr == 'U';
    }
}
