package org.charles.coding.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumbersAddingToSum {
    public static void main(String[] args) {
        int[] numbers={1,3,4,5,78,9,3};
        int sumElement=13;
        int[] out = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(sumElement - numbers[i])){
                out[0] = map.get(sumElement - numbers[i]);
                out[1] = i;
                break;
            }
            map.put(numbers[i], i);
        }

        System.out.println(Arrays.toString(out));
    }
}
