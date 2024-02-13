package org.charles.coding.leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] output = solution(nums);

        for (int i : output) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] nums) {
        int[] output = new int[nums.length];

        // find the number of zeroes
        int zeroIndex = -1;
        boolean moreThanOneZeroes = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                if (zeroIndex == -1)
                    zeroIndex = i;
                else {
                    moreThanOneZeroes = true;
                    break;
                }
            }
        }

        // if there are more than 1 zeroes, all items will be zeroes
        if (moreThanOneZeroes){
            for (int i = 0; i < output.length; i++) {
                output[i]=0;
            }
        }
        else{
            int totalProd = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i != zeroIndex)
                    totalProd *= nums[i];
            }

            for (int i = 0; i < output.length; i++) {
                // if there is only one zero, every item except for the index of zero will be zeroes
                if (zeroIndex != -1){
                    output[i] = i==zeroIndex ? totalProd : 0;
                }
                else {
                    output[i] = totalProd/ nums[i];
                }
            }
        }
        return output;
    }
}
