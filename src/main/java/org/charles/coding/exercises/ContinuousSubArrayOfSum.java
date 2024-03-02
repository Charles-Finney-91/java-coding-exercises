package org.charles.coding.exercises;

public class ContinuousSubArrayOfSum {
    public static void main(String[] args) {
        int[] arr = {15, 4, -2, 2, 1, 3, 3, 0};
        int targetSum = 4;
        System.out.println(v1(arr, targetSum));
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
}
