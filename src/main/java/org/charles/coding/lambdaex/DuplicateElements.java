package org.charles.coding.lambdaex;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElements {
    public static void main(String[] args) {
        int[] array = {10,15,8,49,25,98,98,32,15};
        System.out.println(duplicatesV2(array));
    }

    private static String duplicatesV1(int[] array){
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .map(e -> e.getKey()+"")
                .collect(Collectors.joining(", "));
    }

    private static String duplicatesV2(int[] array){
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(array).boxed()
                .filter(i -> !set.add(i))
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
