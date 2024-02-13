package org.charles.coding.leetcode;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {2,1,5,0,4,6};
        System.out.println(increasingTriplet(nums));
    }

    private static boolean increasingTriplet(int[] nums) {
        // GREEDY Algorithm
        int a=Integer.MAX_VALUE, b=Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= a) a = num;
            else if (num <= b) b = num;
            else return true;
        }
        return false;
    }
}
