package org.charles.coding.dsa.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11,13,2,4,6,8,10,12,14,15};
        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int minIdx, int maxIdx){
        if (minIdx < maxIdx){
            int midIdx = minIdx + (maxIdx - minIdx)/2;
            // sort left array
            sort(arr, minIdx, midIdx);
            // sort right array
            sort(arr, midIdx+1, maxIdx);
            // merge sorted arrays
            merge(arr, minIdx, midIdx, maxIdx);
        }
    }

    private static void merge(int[] arr, int minIdx, int midIdx, int maxIdx){
        int[] leftArr = new int[midIdx - minIdx];
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[minIdx + i];
        }

        int[] rightArr = new int[maxIdx - midIdx];
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[midIdx+i];
        }

        int i=0,j=0,k=minIdx;
        while (i<leftArr.length && j<rightArr.length){
            if (leftArr[i] < rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];
        }
        while (i<leftArr.length)
            arr[k++] = leftArr[i++];
        while (j<rightArr.length)
            arr[k++] = rightArr[j++];
    }
}
