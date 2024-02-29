package org.charles.coding.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2,7,4,1,5};
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int minIdx = i;
            int j = i+1;
            while (j<len){
                minIdx = (arr[minIdx] <= arr[j]) ? minIdx : j;
                j++;
            }
            swap(arr, i, minIdx);
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int minIdx) {
        if(i!=minIdx){
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
