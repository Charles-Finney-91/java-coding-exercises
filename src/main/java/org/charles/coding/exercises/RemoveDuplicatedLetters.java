package org.charles.coding.exercises;

import java.util.stream.Collectors;

public class RemoveDuplicatedLetters {
    public static void main(String[] args) {
        String input = "howareyoucharles";
        System.out.println(input.indexOf('h'));
        StringBuilder sb = new StringBuilder();

        input.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1).forEach(entry -> sb.append(entry.getKey()));

        System.out.println(sb);
    }
}
