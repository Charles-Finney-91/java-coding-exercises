package org.charles.coding.utils;

import java.util.Arrays;
import java.util.Random;

public class RandomIntegerArrayGenerator {
    public static int[] generateRandomArray(int arrayLength){
        Random rand = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(arrayLength * (arrayLength >> 1));
        }
        System.out.printf("Generated array: %s\n", Arrays.toString(array));
        return array;
    }
}
