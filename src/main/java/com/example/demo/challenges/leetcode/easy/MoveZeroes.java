package com.example.demo.challenges.leetcode.easy;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String... args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {

        String s = "abc";
        System.out.println(s.indexOf('a'));
        System.out.println(s.indexOf('b'));
        System.out.println(s.indexOf('c'));

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                sb.append(nums[i]);
                sb.append(",");
                count++;
            }
        }

        for (int i = count; i < nums.length; i++) {
            sb.append("0,");
        }

        String[] noArray = sb.toString().split(",");

        for (int i = 0; i < noArray.length; i++) {
            nums[i] = Integer.parseInt(noArray[i]);
        }

        System.out.println("nums -> " + Arrays.toString(nums));
    }
}
