package org.charles.coding.leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,0,3,0,0,0,1,1,1,1,3,1,1,1};
        System.out.println(maxAreaV2(height));
    }

    private static int maxArea(int[] height) {
        int i=0;
        int j=height.length;
        int area=0;
        while (i<j){
            area = Math.max(area, (Math.min(height[i], height[j]) * (j-i)));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return area;
    }

    private static int maxAreaV2(int[] height) {
        int i=0;
        int j=height.length-1;
        int sideHeight;
        int area=0;
        while (i<j){
            sideHeight=Math.min(height[i], height[j]);
            area = Math.max(area, (sideHeight * (j-i)));
            while (i<j && height[i]<=sideHeight)
                i++;
            while (i<j && height[j]<=sideHeight)
                j--;
        }
        return area;
    }
}
