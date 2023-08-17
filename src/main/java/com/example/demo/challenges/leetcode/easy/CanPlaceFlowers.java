package com.example.demo.challenges.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's,
 * where 0 means empty
 * and 1 means not empty,
 * and an integer n,
 * return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * <p>
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * <p>
 * Constraints:
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */
@Slf4j
public class CanPlaceFlowers {

    public static void main(String... args) {

        int[] flowerbed = new int[]{1, 0, 0, 0, 1};
        int plant = 1;
        log.info("flowerbed : {} & plant : {} -> {}", flowerbed, plant, canPlaceFlowers(flowerbed, plant));

        flowerbed = new int[]{1, 0, 0, 0, 1};
        plant = 2;
        log.info("flowerbed : {} & plant : {} -> {}", flowerbed, plant, canPlaceFlowers(flowerbed, plant));

        flowerbed = new int[]{0, 1, 0, 0, 0, 1};
        plant = 1;
        log.info("flowerbed : {} & plant : {} -> {}", flowerbed, plant, canPlaceFlowers(flowerbed, plant));

        flowerbed = new int[]{0, 1, 0, 0, 1};
        plant = 2;
        log.info("flowerbed : {} & plant : {} -> {}", flowerbed, plant, canPlaceFlowers(flowerbed, plant));

        flowerbed = new int[]{0, 1, 0, 1, 0, 0, 0, 1};
        plant = 2;
        log.info("flowerbed : {} & plant : {} -> {}", flowerbed, plant, canPlaceFlowers(flowerbed, plant));

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (emptyRightPlot && emptyLeftPlot) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}
