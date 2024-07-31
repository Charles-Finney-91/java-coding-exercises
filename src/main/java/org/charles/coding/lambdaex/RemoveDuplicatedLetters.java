package org.charles.coding.lambdaex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveDuplicatedLetters {
    public static void main(String[] args) {
        String input = "howareyoucharles";
        System.out.println(input.indexOf('h'));
        StringBuilder sb = new StringBuilder();

        input.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .forEach(entry -> sb.append(entry.getKey()));

        String out = input.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(e -> String.valueOf(e.getKey()))
                .collect(Collectors.joining());

        System.out.println(out);
    }
}
