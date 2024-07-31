package org.charles.coding.exercises;

/**
 * Kadanes' Greedy Algorithm
 */
public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] array = {1,2,-1,-3,4,1,2};
        int currMax = Integer.MIN_VALUE;
        int total = Integer.MIN_VALUE;
        int lp=0,rp=0;

        /**
         * Kadanes' algorithm
         * If a number in the array is greater than the sum of that number and previous sums,
         * it means the previous summed data will undermine the current number going forward.
         * So we will neglect the previous sum data and move forward from the current number.
         * Thus finding the largest sum.
         *
         * currMax = Math.max(currMax+array[i], array[i])
         */
        for (int i = 0; i < array.length; i++) {
            int temp = array[i] + currMax;
            if (array[i] < temp){
                currMax = temp;
                rp++;
            }
            else {
                currMax = array[i];
                lp =i; rp=i;
            }
            total = Math.max(currMax, total);
        }

        System.out.println(lp + " " + rp);

    }
}
