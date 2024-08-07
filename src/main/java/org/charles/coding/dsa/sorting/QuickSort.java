package org.charles.coding.dsa.sorting;

import org.charles.coding.utils.RandomIntegerArrayGenerator;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = RandomIntegerArrayGenerator.generateRandomArray(10);
        System.out.println(Arrays.toString(array));
        quicksort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void quicksort(int[] array, int minIndex, int maxIndex){
        if (minIndex < maxIndex){
            int pivot = array[maxIndex];
            int leftP = partition(array, minIndex, maxIndex, pivot);
            // sort left
            quicksort(array, minIndex, leftP-1);
            // sort right
            quicksort(array, leftP+1, maxIndex);
        }
    }

    private static int partition(int[] array, int minIndex, int maxIndex, int pivot) {
        int leftP=minIndex, rightP=maxIndex;
        while (leftP<rightP){
            while (array[leftP] <= pivot && leftP<rightP)
                leftP++;
            while (array[rightP] >= pivot && leftP<rightP)
                rightP--;
            swap(array, leftP, rightP);
        }
        swap(array, leftP, maxIndex);
        return leftP;
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
