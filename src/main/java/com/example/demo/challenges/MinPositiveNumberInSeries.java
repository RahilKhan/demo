package com.example.demo.challenges;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Find the smallest positive integer that does not occur in a given sequence.
 * 0 is to be excluded.
 * <p>
 * eg.
 * {1, 3, 5} -> 2
 * {-1, -3, -2, 0} -> 1
 * {-1, -3, -2, 0, 2} -> 1
 * {1, 2, 3, 4, 6,9} -> 5
 */

@Slf4j
public class MinPositiveNumberInSeries {

    public static void main(String... args) {
        int[] A = {1, 2, 3, 4, 6, 9};
        findMinNo(A);
        findMinNo(new int[]{1, 3, 5});
        findMinNo(new int[]{-1, -3, -2, 0});
        findMinNo(new int[]{-1, -3, -2, 0, 2});
        findMinNo(new int[]{-1, -3, -2});
        findMinNo(new int[]{-1, -3, 2});
        findMinNo(new int[]{-1, -3, 1});
        findMinNo(new int[]{-1, -3, 5});

        chatGptFindSmallestMissingPositive(A);
        chatGptFindSmallestMissingPositive(new int[]{1, 3, 5});
        chatGptFindSmallestMissingPositive(new int[]{-1, -3, -2, 0});
        chatGptFindSmallestMissingPositive(new int[]{-1, -3, -2, 0, 2});
        chatGptFindSmallestMissingPositive(new int[]{-1, -3, -2});
        chatGptFindSmallestMissingPositive(new int[]{-1, -3, 2});
        chatGptFindSmallestMissingPositive(new int[]{-1, -3, 1});
        chatGptFindSmallestMissingPositive(new int[]{-1, -3, 5});
    }


    /**
     * Explanation:
     * 1. First, we sort the given sequence in ascending order using Arrays.sort().
     * 2. We initialize smallestMissing to 1, which is the smallest positive integer that we are looking for.
     * 3. We then iterate through the sorted array. If the current element is equal to smallestMissing,
     * it means the element is present in the sequence, so we increment smallestMissing to check the next positive integer.
     * 4. Once we find the first missing positive integer, the loop will stop, and we return smallestMissing.
     *
     * @param nums
     * @return
     */
    public static int chatGptFindSmallestMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int smallestMissing = 1;

        for (int num : nums) {
            log.info("\t num ==> {}",num);
            if (num == smallestMissing) {
                smallestMissing++;
            }else{
                break;
            }
        }
        log.info("chatGptFindSmallestMissingPositive({}) :: minNum: {}", nums, smallestMissing);
        return smallestMissing;
    }

    public static void findMinNo(int[] A) {
        Set<Integer> intSet = Arrays.stream(A).boxed().collect(Collectors.toSet());
        List<Integer> numList = intSet.stream().sorted().toList();

        int minNum = 0;
        if (numList.get(numList.size() - 1) == 1) {
            minNum = 2;
            log.info("Array -> {} :: minNum: {}", A, minNum);
            return;
        }

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) < 0)
                minNum = 1;
            else if (numList.get(i) > 0) {
                if (!numList.contains(1))
                    minNum = 1;
                else {
                    int loopNum = numList.get(i);
                    if (loopNum > 1 && !numList.contains(loopNum - 1)) {
                        if (minNum == 0)
                            minNum = loopNum - 1;
                        else if (minNum > loopNum - 1)
                            minNum = loopNum - 1;
                    }
                }
            }
        }
        log.info("Array -> {} :: minNum: {}", A, minNum);

    }

}
