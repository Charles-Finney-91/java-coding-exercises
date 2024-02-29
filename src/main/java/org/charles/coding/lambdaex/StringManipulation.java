package org.charles.coding.lambdaex;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringManipulation {
    public static void main(String[] args) {
        // Output: ["first_data", "last_data", "missing", "missing", "other_data", "second_data"]
        String[] array = {"First  data", "Second data", "", "other DATA", "", "LAST DATA"};
        System.out.println(manipulate(array));
    }

    private static String manipulate(String[] array){
        return Arrays.stream(array)
                .map(String::toLowerCase)
                .map(s -> { if(s.isEmpty()) s="missing"; return s; })
                .map(s -> s.replaceAll("\\s+", "_"))
                .collect(Collectors.joining(", "));
    }
}
