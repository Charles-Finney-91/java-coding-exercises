package org.charles.coding.exercises;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
//        int[] arr1 = {1,3,5,7,9,11,13};
//        int[] arr2 = {2,4,6,8,10,12,14};
//        System.out.println(Arrays.toString(mergeSortedElementsV1(arr1, arr2)));

        int[] arr = {1,3,5,7,9,11,13,2,4,6,8,10,12,14};
        mergeSortedElementsV2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] mergeSortedElementsV1(int[] arr1, int[] arr2) {
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;

        int[] out = new int[arr1Len + arr2Len];

        int i=0,j=0,k=0;
        while (i<arr1Len && j<arr2Len){
            if (arr1[i]< arr2[j])
                out[k++] = arr1[i++];
            else
                out[k++] = arr2[j++];
        }

        while (i<arr1Len)
            out[k++] = arr1[i++];
        while (j<arr2Len)
            out[k++] = arr2[j++];
        return out;
    }

    private static void mergeSortedElementsV2(int[] arr){
        int arrLen = arr.length;
        int midIdx = arrLen/2;

        int[] arr1 = new int[midIdx];
        int i=0, k=0;
        while(i<arr1.length)
            arr1[i++] = arr[k++];

        int[] arr2 = new int[arrLen - midIdx];
        int j=0; k=midIdx;
        while(j<arr2.length)
            arr2[j++] = arr[k++];

        i=0;j=0;k=0;
        while(i<arr1.length && j<arr2.length){
            if (arr1[i] < arr2[j])
                arr[k++] = arr1[i++];
            else
                arr[k++] = arr2[j++];
        }

        while(i<arr1.length)
            arr[k++] = arr1[i++];
        while(j<arr2.length)
            arr[k++] = arr2[j++];
    }
}
