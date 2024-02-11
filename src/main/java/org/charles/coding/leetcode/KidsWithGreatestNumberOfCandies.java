package org.charles.coding.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandiesInInput = 0;
        for (int candy : candies) {
            maxCandiesInInput = maxCandiesInInput > candy ? maxCandiesInInput : candy;
        }
        int i=0;
        while(i < candies.length) {
            result.add(candies[i++] + extraCandies >= maxCandiesInInput);
        }
        return result;
    }
}
