package org.charles.coding.lambdaex;

import java.util.Arrays;

public class NumbersStartingWith {
    public static void main(String[] args) {
        int[] array = {10,15,8,49,25,98,32};
        int num = 1;

        Arrays.stream(array)
                .mapToObj(String::valueOf)
                .filter(s -> s.startsWith(num+""))
                .forEach(s -> System.out.print(s + " "));
    }
}
