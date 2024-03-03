package org.charles.coding.exercises;

import java.util.*;

public class LargestContinuousSubArrayOfSum {
    public static void main(String[] args) {
        int[] arr = {15,4,-2,2,1,3,3,0};
        int targetSum = 5;
        System.out.println(Arrays.toString(v2(arr, targetSum)));
    }

    /**
     * Brute Force
     * time: O(n^2)
     * space: O(1)
     */
    private static int v1(int[] arr, int targetSum) {
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            if (targetSum == sum)
                maxCount = 1;
            for(int j = i+1; j< arr.length; j++){
                sum = sum + arr[j];
                if (targetSum == sum)
                    maxCount = Math.max(maxCount, (j-i)+1);
            }
        }
        return maxCount;
    }

    /**
     * Prefix Sum
     * This algorithm uses the prefixed sum to check if we are getting similar values when subtracted with the target sum
     * If we have similar values such that somePrefixSumInMap = currentSum - targetSum,
     * then it means that the elements between somePrefixSumInMap (exclusive) and currentIndex (inclusive),
     * is a sub array that adds up to the target sum
     *
     * example:
     * targetSum = 4
     * |--------------------------------------------------------------|
     * |index                 |  0 |  1 |  2 |  3 |  4 |  5 |  6 |  7 |
     * |--------------------------------------------------------------|
     * |values                | 15 |  4 | -2 |  2 |  1 |  3 |  3 |  0 |
     * |--------------------------------------------------------------|
     * |prefixSum             | 15 | 19 | 17 | 19 | 20 | 23 | 26 | 26 |
     * |--------------------------------------------------------------|
     * |currentSum - targetSum|  * | 15 | 13 | 15 | 16 | 19 | 22 | 22 |
     * |--------------------------------------------------------------|
     *
     * we have sub arrays between index 0 (exclusive prefixSum) and 1 (inclusive currentSum - targetSum)
     * similarly we have sub arrays between index 0 (exclusive prefixSum) and 3 (inclusive currentSum - targetSum)
     * similarly we have sub arrays between index 1 (exclusive prefixSum) and 5 (inclusive currentSum - targetSum)
     *
     * time: O(n)
     * space: O(n)
     */
    private static int[] v2(int[] array, int targetSum){
        int[] out = {-1, -1};

        if (array.length > 0){
            // initializing the instruments
            Map<Integer, Integer> map = new HashMap<>();
            int maxElements = 0;
            int currentSum = array[0];
            map.put(currentSum, 0);

            // edge case when there is one element equal to the targetSum
            if (array[0] == targetSum){
                out[0] = 0;
                out[1] = 0;
            }

            for (int i = 1; i < array.length; i++) {
                // creating the next prefix sum
                currentSum += array[i];
                // getting the index from the map where somePrefixSumInMap = currentSum - targetSum
                Integer refIndex = map.get(currentSum - targetSum);
                if (refIndex != null){
                    // we found the sub array
                    // Since we need the largest subarray
                    // we are keeping track of the number of elements per each sub array we find
                    if(maxElements < i-refIndex){
                        maxElements = i-refIndex;
                        out[0] = refIndex+1;
                        out[1] = i;
                    }
                }
                // we are only adding the indexes if they are not already there.
                // This is done so that we won't lose the previous index if we have same prefix sum values
                map.putIfAbsent(currentSum, i);
            }
        }

        return out;
    }
}
