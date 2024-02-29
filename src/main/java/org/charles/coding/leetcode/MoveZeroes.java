package org.charles.coding.leetcode;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {4,2,4,0,0,3,0,5,1,0}; //
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length>1) {
            int i = 0, j = 1;
            while(i<=length-2 && j<=length-1){
                if (nums[j]==0) {
                    j++;
                }
                else if (nums[i]==0){
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++; j++;
                }
                else if (i==j) {
                    i++; j++;
                }
                else {
                    i++;
                }
            }
        }
    }
}
