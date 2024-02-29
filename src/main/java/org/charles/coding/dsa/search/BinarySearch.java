package org.charles.coding.dsa.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Index of element is: " + search(8, arr, 0, arr.length-1));
    }

    private static int search(int searchable, int[] arr, int minIdx, int maxIdx){
        int midIdx = minIdx + (maxIdx-minIdx)/2;
        if (searchable == arr[midIdx])
            return midIdx;
        else if (searchable < arr[midIdx])
            return search(searchable, arr, minIdx, midIdx -1);
        else
            return search(searchable, arr, midIdx+1, maxIdx);
    }
}
