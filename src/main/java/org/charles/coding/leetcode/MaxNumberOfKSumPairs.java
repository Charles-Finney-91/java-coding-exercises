package org.charles.coding.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,4,3};
        System.out.println(maxOperations(nums, 5));
        System.out.println(Arrays.toString(nums));
    }

    private static int maxOperations(int[] nums, int k) {
        AtomicInteger count = new AtomicInteger();

        // create a frequency map
        if (nums.length>1){
            Map<Integer, Integer> map = new HashMap();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }

            // Lets start counting the sum
            map.forEach((key, value) -> {
                int delta = k - value;
                if (null != map.get(delta) && map.get(delta) == 1) {
                    map.put(key, value - 1);
                    map.put(delta, -1);
                    count.addAndGet(1);

                    if (map.get(delta) == 0)
                        map.remove(delta);
                    if (value == 0)
                        map.remove(key);
                }
            });
        }



        return count.get();
    }

}
