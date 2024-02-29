package org.charles.coding.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,7,4,5,9};
        int length = arr.length;

        // This loop is for iterating through the array n times
        for (int i = 0; i < length; i++) {
            // This is to check if all the swaps are completed.
            boolean isSwapped = false;

            // This loop is for checking the adjacent elements.
            // After the end of each loop, the last element will be in the correct position.
            // So we are omitting the last element from being checked in the subsequent checks using "-i".
            for(int j=0; j<length-1-i; j++){
                isSwapped = swap(arr, j);
            }

            // if all the swaps are completed, we have to stop the loop right there
            if(!isSwapped) break;
        }

        System.out.println(Arrays.toString(arr));
    }

    private static boolean swap(int[] arr, int j){
        if (arr[j] < arr[j+1]){
            int temp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = temp;
            return true;
        }
        return false;
    }
}