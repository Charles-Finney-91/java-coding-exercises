package org.charles.coding.leetcode;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if (length == 0 || (length == 1 && flowerbed[0] == 1)){
            return n==0 ? true : false;
        }

        if (length == 1 && flowerbed[0] == 0){
            return n>=0&&n<=1 ? true : false;
        }

        int i=0, counter=0, prev, next;
        while (i<length){
            prev = i==0 ? 0 : flowerbed[i-1];
            next = i==length-1 ? 0 : flowerbed[i+1];
            if (prev==0 && flowerbed[i]==0 && next==0){
                flowerbed[i] = 1;
                counter++;
            }
            i++;
        }
        return counter >= n;
    }
}
