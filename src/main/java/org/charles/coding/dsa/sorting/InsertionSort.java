package org.charles.coding.dsa.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,7,4,1,5};

        // This loop is for the unsorted array part
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i-1;
            // This loop is for the sorted array
            while (j >= 0 && arr[j] < temp){
                arr[j+1] = arr[j--];
            }
            arr[j+1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
