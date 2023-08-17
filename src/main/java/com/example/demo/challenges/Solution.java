package com.example.demo.challenges;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A) {
        int n = A.length;
        int minVal = Arrays.stream(A).min().getAsInt();
        int maxVal = Arrays.stream(A).max().getAsInt();

        int result = Integer.MAX_VALUE;
        int left = minVal;
        int right = maxVal;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(A, mid, 3)) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // Helper function to check if it's possible to divide the array into k groups
    // such that the maximum difference in each group is less than or equal to maxDiff.
    private boolean isPossible(int[] A, int maxDiff, int k) {
        int n = A.length;
        int currentGroupSize = 0;
        int currentGroupMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (currentGroupSize == k) {
                return false;
            }

            currentGroupMax = Math.max(currentGroupMax, A[i]);

            if (currentGroupMax - A[i] > maxDiff) {
                currentGroupSize++;
                currentGroupMax = A[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {11, 5, 3, 12, 6, 8, 1, 7, 4};
        Arrays.sort(A);
        Arrays.stream(A).forEach(System.out::println);
        int result = solution.solution(A);
        System.out.println("Minimum possible maximum difference: " + result);
    }
}
