package com.example.demo.challenges.parenthesis;

import static com.itextpdf.html2pdf.html.AttributeConstants.i;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * Example 1:
 * Input: s = "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * <p>
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParenthesis {

    public static void main(String... args) {
        String s = "({()})[]{}({})()";
        isValid(s);
    }

    public static boolean isValid(String s) {
        boolean isValid = false;

        char[] charArray = s.toCharArray();
        char[] cArray = new char[s.length()];

        int j = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (isOpenBracket(charArray[i])) {
                cArray[i] = charArray[i];
            }else if (isClosingBracket(charArray[i])) {
                
            }
        }

        return isValid;

    }

    public static boolean isOpenBracket(char chr) {
        return true;
    }

    public static boolean isClosingBracket(char chr) {
        return true;
    }
}
