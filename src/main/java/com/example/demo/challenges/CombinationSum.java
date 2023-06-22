package com.example.demo.challenges;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/combination-sum/
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less
 * than 150 combinations for the given input.
 * <p>
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * <p>
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 * <p>
 * Constraints:
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */

@Slf4j
public class CombinationSum {

    public static void main(String... args) {
        int[] intArr = new int[]{6, 7, 2, 3};
        findCombinationSum(intArr, 7);
        findCombinationSum(new int[]{6, 2, 7, 8, 6, 2, 3, 9, 8, 6, 3}, 7);
        findCombinationSum(new int[]{8, 3, 2, 9, 2, 6, 2, 8, 3, 2, 9}, 7);
        findCombinationSum(new int[]{-2, 6, 2, -8, 9, -3, 13, 1, 2, 6}, 7);
        findCombinationSum(new int[]{-2, -3, 0, 1, 2, 6, 5, -8, 9, 13, 1, 2, 6}, 9);
    }

    private static void findCombinationSum(int[] intArr, int target) {
        log.info("------------------------------------------");
        Set<Integer> intSet = Arrays.stream(intArr).boxed().collect(Collectors.toSet());
        List<Integer> integerList = intSet.stream().sorted().toList();
        log.info("integerList : {}, target -> {}", integerList, target);

        List<String> combinationList = new ArrayList<>();
        String combination = "";
        if (integerList.contains(target)) {
            combinationList.add(String.valueOf(target));
        }

        if (integerList.get(integerList.size() - 1) == target) {
            findCombination(integerList, target);
        } else {
            int smallerNo = findNumSmallerThanTarget(integerList, target);
            log.info("smallerNo : {}", smallerNo);

            int index = integerList.indexOf(smallerNo);
            findCombination(integerList.subList(0, index), target);
        }

        log.info("combinationList : {}", combinationList);
    }

    private static int findNumSmallerThanTarget(List<Integer> integerList, int target) {
//        log.info("intermediate integerList : {}", integerList);

        int lstLen = integerList.size();
        int mid = lstLen / 2;

        if (lstLen < 2) {
            return integerList.get(0);
        }

        if (integerList.get(mid) == target)
            return integerList.get(mid);

        if (integerList.get(mid) < target) {
            return findNumSmallerThanTarget(integerList.subList(mid, integerList.size()), target);
        }

        return findNumSmallerThanTarget(integerList.subList(0, mid), target);
    }

    private static void findCombination(List<Integer> integerList, int target) {

    }


}
