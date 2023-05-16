/**
 *
 */
package com.example.demo.coding;

/**
 * Write a program for the recursive implementation of Insertion Sort. Input:
 * arr[] = [5, 2, 3, 1]
 *
 * 5 2 -> 2,5 3 -> 2;3,5 1 -> 2,3;1,5 ' -> 2;1,3;5 -> 1,2;3,5
 *
 * @author Rahil_Khan
 *
 */
public class InsertionSort {

    /**
     * @param args
     */
    public static void main(String[] args) {

//		insertSort();
        System.out.println("\n ------------------------------- \n");

        int arr[] = {5, 2, 3, 1, 7, 4, 8};
        System.out.print(" initial array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        int[] sortedArray = insertionSortExample(arr);
        System.out.print("\n sortedArray   : ");
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i]);
        }

    }

    public static int[] insertionSortExample(int[] array) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
        return array;
    }

    private static void insertSort() {
        int arr[] = {5, 2, 3, 1, 7, 4, 8};
        int arr2[] = new int[arr.length];

        for (int i = 0; i <= arr.length - 1; i++) {
            int currNum = arr[i];
            System.out.println("currNum : " + currNum);

            if (arr[i] < arr[i + 1]) {
//				arr[i] = arr[i+1];
//				arr[i+1] = currNum;
                int idx = i + 1;
                System.out.println("arr[" + i + "] : " + arr[i] + " - arr[" + idx + "] : " + arr[idx]);
//				
            }

        }

        System.out.println("arr : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        System.out.println("\narr2 : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr2[i]);
        }
    }

}
