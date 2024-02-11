package org.charles.coding.leetcode;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n > 0){
            if (flowerbed.length==1 && flowerbed[0] == 0 && n==1){
                return true;
            }
            else if (flowerbed.length==1 && flowerbed[0] == 1 && n==1){
                return false;
            }
            else {

            }
        }
        return true;
    }
}
