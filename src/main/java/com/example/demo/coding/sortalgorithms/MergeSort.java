package com.example.demo.coding.sortalgorithms;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class MergeSort {

    public static void main(String... args) {

        int[] randIntArr = new int[10];
        Random rand = new Random();

        log.info("Original Array");
        for (int i = 0; i < 10; i++) {
            randIntArr[i] = rand.nextInt(100);
            log.info("{} - {}", i, randIntArr[i]);
        }

        randIntArr = mergeSort(randIntArr);

        log.info("MergeSorted Array");
        for (int i = 0; i < randIntArr.length; i++) {
            log.info("{} - {}", i, randIntArr[i]);
        }

    }

    public static int[] mergeSort(int[] inputArr) {
        int arrLen = inputArr.length;
        int mid = arrLen / 2;
        int[] leftArr = new int[mid];
        int[] rtArr = new int[arrLen - mid];

        if (arrLen < 2) {
            return inputArr;
        }

        for (int i = 0; i < mid; i++) {
            leftArr[i] = inputArr[i];
        }
        for (int i = mid; i < arrLen; i++) {
            rtArr[i - mid] = inputArr[i];
        }

        mergeSort(leftArr);
        mergeSort(rtArr);

        return merge(inputArr, leftArr, rtArr);

    }

    public static int[] merge(int[] inputArr, int[] leftArr, int[] rtArr) {
        int i = 0, j = 0, k = 0;

        while (i < leftArr.length && j < rtArr.length) {
            if (leftArr[i] < rtArr[j]) {
                inputArr[k] = leftArr[i];
                i++;
            } else {
                inputArr[k] = rtArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length) {
            inputArr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rtArr.length) {
            inputArr[k] = rtArr[j];
            j++;
            k++;
        }

        return inputArr;
    }


}