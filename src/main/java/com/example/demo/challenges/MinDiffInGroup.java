package com.example.demo.challenges;

import java.util.Arrays;

/**
 * There is an array A consisting of N integers. Divide them into three non-empty groups.
 * In each group we calculate the difference between the largest and smallest integer.
 * Our goal is to make the maximum of these differences as small as possible.
 * <p>
 * For example, given A = [11, 5, 3, 12, 6, 8, 1, 7, 4], we can divide the elements into three groups as follows:
 * <p>
 * Distribution D1:
 * [3, 1, 4] − the difference between elements is 3;
 * [5, 6, 8, 7] − the difference is also 3;
 * [11, 12] − the difference is 1.
 * The maximum difference for D1 is 3.
 * <p>
 * Distribution D2:
 * [1,3] − the difference between elements is 2;
 * [5, 6, 4] − the difference is also 2;
 * [7, 8, 11, 12] − the difference is 5.
 * The maximum difference for D2 is 5.
 * <p>
 * In this example 3 happens to be the minimum maximum possible among all distributions.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * such that, given an array A, returns the minimum possible maximum result as explained above.
 *
 * Solution:
 * https://www.quora.com/How-can-n-integers-be-partitioned-into-m-non-empty-subsets-such-that-the-difference-between-the-maximum-and-minimum-subset-sums-is-minimized
 *     public void partition(int a[], int ptr, List<Integer> [] buckets){
 *     	if(ptr == a.length){
 *     		int diff = getMaxDiff(buckets);
 *     		if(diff < minDiff){
 *     		    result = copyOf(buckets);
 *     		    minDiff = diff;
 *                        }
 *     		return; *     	}
 *     	for(int i = 0;i<m;i++){
 *     		if(getSum(buckets[i]) <= totalSum/m){
 *     		    buckets[i].add(a[ptr]);
 *     		    partition(a, ptr+1, buckets);
 *     		 buckets[i].remove(buckets[i].siz
 *        }
 *     	}
 *     }
 */
public class MinDiffInGroup {

    public static void main(String[] args) {
        MinDiffInGroup minDiffInGroup = new MinDiffInGroup();
        int[] A = {11, 5, 3, 12, 6, 8, 1, 7, 4};
        int result = minDiffInGroup.solution(A);
        System.out.println("Minimum possible maximum difference: " + result);
    }
    public int solution(int[] A) {
//        int n = A.length;
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

}


