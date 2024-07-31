package org.charles.coding.dsa.sorting;

import org.charles.coding.utils.RandomIntegerArrayGenerator;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 7, 5, 2, 4, 6, 8, 10, 9};
        int[] arr = RandomIntegerArrayGenerator.generateRandomArray(10);
        System.out.printf("Before Sorting: %s \n", Arrays.toString(arr));
        sort(arr, 0, arr.length-1);
        System.out.printf("After Sorting: %s \n", Arrays.toString(arr));
    }

    private static void sort(int[] arr, int minIdx, int maxIdx){
        if(minIdx<maxIdx){
            int midIdx = (maxIdx + minIdx) / 2;
            // sort left
            sort(arr, minIdx, midIdx);
            // sort right
            sort(arr, midIdx+1, maxIdx);
            // merge sorted arrays
            merge(arr, minIdx, midIdx, maxIdx);
        }
    }

    private static void merge(int[] arr, int minIdx, int midIdx, int maxIdx){
        // left temp arr
//        int[] leftTemp = Arrays.copyOfRange(arr, minIdx, midIdx+1);
        int[] leftTemp = new int[midIdx - minIdx + 1];
        for (int i = 0; i < leftTemp.length; i++) {
            leftTemp[i] = arr[minIdx + i];
        }

        // right temp arr
//        int[] rightTemp = Arrays.copyOfRange(arr, midIdx+1, maxIdx+1);
        int[] rightTemp = new int[maxIdx - midIdx];
        for (int j = 0; j < rightTemp.length; j++) {
            rightTemp[j] = arr[midIdx + 1 + j];
        }

        // merge temp arrays into main array
        int i=0,j=0;
        while(i<leftTemp.length && j<rightTemp.length)
            arr[minIdx++] = (leftTemp[i]<rightTemp[j]) ? leftTemp[i++] : rightTemp[j++];
        while(i<leftTemp.length)
            arr[minIdx++] = leftTemp[i++];
        while(j<rightTemp.length)
            arr[minIdx++] = rightTemp[j++];
    }


}
