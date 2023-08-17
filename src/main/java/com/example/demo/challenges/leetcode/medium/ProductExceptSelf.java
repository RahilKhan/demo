package com.example.demo.challenges.leetcode.medium;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String...args){
        int[] nums = new int[]{1,2,3,4};

        System.out.print(Arrays.toString(nums) +  " -> " + Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        int left = 1;
        for(int i =0 ; i< length; i++){
            answer[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for(int i = length -1; i>=0 ; i--){
            answer[i] *= right;
            right *= nums[i];
        }

        return answer;

    }
}
